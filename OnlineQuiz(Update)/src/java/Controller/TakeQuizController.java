/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.TakeQuizDAO;
import Model.Answer;
import Model.Question;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author congfptu
 */
public class TakeQuizController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    public TakeQuizController() {
 
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            TakeQuizDAO qDao = new TakeQuizDAO();
            int maximumQuiz = qDao.countQuestion();
            if (request.getParameter("number") == null) {
                //the number parameter is not requested then return to entering number quiz page
                request.setAttribute("maxQuiz", maximumQuiz);
                request.getRequestDispatcher("view/enterNumQuiz.jsp").forward(request, response);
            } else {
                //check number of questions then goto taking quiz page
                try {
                    String num = request.getParameter("number").trim();
                    if (num.compareTo("") == 0) {
                        request.setAttribute("mess", "Do not empty number of questions");
                        request.getRequestDispatcher("view/enterNumQuiz.jsp").forward(request, response);
                    }
                    int number = Integer.parseInt(num);
                    request.setAttribute("number", number);
                    if (number > maximumQuiz) {
                        //return mess when number of question over total question in database 
                        request.setAttribute("mess", "Please enter number of question under " + maximumQuiz);
                        request.getRequestDispatcher("view/enterNumQuiz.jsp").forward(request, response);
                    } else if (number < 1) {
                        request.setAttribute("mess", "Please enter number of question greater than 1");
                        request.getRequestDispatcher("view/enterNumQuiz.jsp").forward(request, response);
                    } else {
                        HttpSession session = request.getSession();
                        User u = (User) session.getAttribute("user");
                        //set duration time measured in milliseconds is the limit time to take all quizzes for user
                        //with that number of question
                        ArrayList<Question> ques = new ArrayList<Question>();
                        if (session.getAttribute(u.getUserName() + "questions") != null) {
                            ques = (ArrayList<Question>) session.getAttribute(u.getUserName() + "questions");
                        }
                        if (session.getAttribute("duration") == null
                                || session.getAttribute("duration") != null
                                && number != ques.size()) {
                            //set  new questions when user take quiz for the first time
                            //or user request a difference quantity of question

                            long startTime = System.currentTimeMillis();
                            //start time when user taking the quiz is ticked
                            //   this.startTimes.put(u.getUserName(), startTime);
                            //  this.questions.put(u.getUserName(), qDao.getQuestions(number));
                            session.setAttribute(u.getUserName() + "startTime", startTime);
                            session.setAttribute(u.getUserName() + "questions", qDao.getQuestions(number));
                            ques = (ArrayList<Question>) session.getAttribute(u.getUserName() + "questions");
                            //request.setAttribute("questions", this.questions.get(u.getUserName()));
                            //long duration = this.questions.get(u.getUserName()).size() * 60 * 1000;
                            long duration = ques.size() * 60 * 1000;
                            long check = 10 * 1000;
                            session.setAttribute("duration", duration);
                            //set duration time for all questions
                            session.setAttribute("questions", ques);
                            request.setAttribute("labeltime", formartTimeLable(duration));
                            //set label time
                            request.getRequestDispatcher("view/takequiz.jsp").forward(request, response);
                        } else {
                            //when user reload page still keep the time to do test

                            long duration = (long) session.getAttribute("duration");

                            long currentTime = System.currentTimeMillis();

                            long takedTime = currentTime - (long) session.getAttribute(u.getUserName() + "startTime");
                            //calculate the time has been taked before and minus the delaytime.

                            long remainTime = duration - takedTime;
                            //calculate the remain time of user

                            if (remainTime > 0) {
                                request.setAttribute("labeltime", formartTimeLable(remainTime));
                                //set label time
                                request.getRequestDispatcher("view/takequiz.jsp").forward(request, response);
                            } else {
                                request.setAttribute("mess", "Your result has been rejected!");
                                request.getRequestDispatcher("view/result.jsp").forward(request, response);
                            }
                        }
                    }
                } catch (Exception ex) {
                    request.setAttribute("mess", "Please input number!");
                    request.getRequestDispatcher("view/enterNumQuiz.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            HttpSession session = request.getSession(false);
            User u = (User) session.getAttribute("user");
            String result = request.getParameter("result");
            long currentTime = System.currentTimeMillis();
            //long startTime = this.startTimes.get(u.getUserName());
            long startTime = (long) session.getAttribute(u.getUserName() + "startTime");
            long duration = (long) session.getAttribute("duration");

            //get current time when user sent result of quiz to server
            long takingTime = (currentTime - startTime - 500);
            //takingTime is the time of the user taking all of the quizzes
            if (takingTime > duration) {
                //takingTime is greater than duration so that result is not accepted.
                request.setAttribute("mess", "Your result has been rejected!");
                request.getRequestDispatcher("view/result.jsp").forward(request, response);
            } else {
                ArrayList<Question> ques = (ArrayList<Question>) session.getAttribute(u.getUserName() + "questions");
                float score = (float) (calculateScore(result.trim().split(" "), u.getUserName(), ques) * 10.0);
                //calculate the score
                DecimalFormat df = new DecimalFormat("#.#");

                String formatted = df.format(score);
                request.setAttribute("mark", Float.parseFloat(formatted));

                request.setAttribute("percent", Float.parseFloat(formatted) * 10);
                //calculated the percent of the result
                String isPass = score < 5.0 ? "Not Pass" : "Pass";
                //is pass or not
                request.setAttribute("isPass", isPass);
                request.getRequestDispatcher("view/result.jsp").forward(request, response);
            }
            session.removeAttribute("duration");
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     *
     * @param results
     * @param userName
     * @return score Purpose: calculate the score for user
     */
    public float calculateScore(String[] results, String userName, ArrayList<Question> ques) {
        int num = 0;
        ArrayList<String> trueAnswerString = new ArrayList<>();
        ArrayList<String> falseAnswerString = new ArrayList<>();

        for (Question question : ques) {
            //loop each question to check correct or not
            for (Answer answer : question.getAnswers()) {
                //loop each answer of each question to get each false and true answer
                if (answer.isIsTrue() == true) {
                    //get each true answer then push to the true answer arraylist
                    trueAnswerString.add(answer.getId());
                } else {
                    //get each true answer then push to the false answer arraylist
                    falseAnswerString.add(answer.getId());
                }
            }
            if (checkAnswer(results, trueAnswerString, falseAnswerString)) {
                //then check that answer whether correct or not in each corresponding question
                num++;
            }
            trueAnswerString.removeAll(trueAnswerString);
            //remove all true and false answer array list for next question
            falseAnswerString.removeAll(falseAnswerString);
        }

        return (float) num / ques.size();
    }

    /**
     *
     * @param millis
     * @return
     */
    public String formartTimeLable(long millis) {
        long minutes = (millis / 1000) / 60;
        long seconds = (millis / 1000) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public boolean checkAnswer(String[] results,
            ArrayList<String> trueAnswerString,
            ArrayList<String> falseAnswerString) {
        int numOfTrueAnswer = 0;
        for (String result : results) {
            //loop each result string of all answer that client sent to server
            if (falseAnswerString.contains(result)) {
                //if one of all answer is in false answer of that question
                // then return that answer of question is false
                return false;
            }
        }
        for (String result : results) {
            //loop each result string of all answer that client sent to server
            if (trueAnswerString.contains(result)) {
                //if one of all answer is in false answer of that question
                // then return numOfTrueAnswer increase to 1
                numOfTrueAnswer++;
            }
        }

        return numOfTrueAnswer == trueAnswerString.size();
        //return whether quantity of true answer that question is enough or not
    }
}
