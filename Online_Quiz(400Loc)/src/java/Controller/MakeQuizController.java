    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AnsDAO;
import Dao.TakeQuizDAO;
import Model.Answer;
import Model.Question;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author congfptu
 */
public class MakeQuizController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MakeQuizController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MakeQuizController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            request.getRequestDispatcher("view/makequiz.jsp").forward(request, response);
        } catch (IOException e) {
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
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
            TakeQuizDAO qDao = new TakeQuizDAO();
            AnsDAO aDao = new AnsDAO();
            String question = request.getParameter("question").trim();
            String option1 = request.getParameter("option1").trim();
            String option2 = request.getParameter("option2").trim();
            String option3 = request.getParameter("option3").trim();
            String option4 = request.getParameter("option4").trim();
            // input must no empty
            if (     question.compareTo("") == 0
                    || option1.compareTo("") == 0
                    || option2.compareTo("") == 0
                    || option3.compareTo("") == 0
                    || option4.compareTo("") == 0) {
                request.setAttribute("errorEmpty", "Do not empty");
                request.getRequestDispatcher("/view/makequiz.jsp").forward(request, response);
            }
            else{
            String qId = qDao.generateRandomID(10);
            //generate random and unique id for question
            String[] aIds = aDao.generateRandomIDs(10);
            //generate 4 random and unique id for each answer
            ArrayList<Answer> answers = new ArrayList<>();
            String op1 = request.getParameter("op1");
            String op2 = request.getParameter("op2");
            String op3 = request.getParameter("op3");
            String op4 = request.getParameter("op4"); 
             //check option at least 1 and maximum is 3
            if (checkQuatityOfCheckBox(op1, op2, op3, op4)) {
                answers.add(new Answer(aIds[0], option1, checkBoxValue(op1)));
                answers.add(new Answer(aIds[1], option2, checkBoxValue(op2)));
                answers.add(new Answer(aIds[2], option3, checkBoxValue(op3)));
                answers.add(new Answer(aIds[3], option4, checkBoxValue(op4)));

                long millis = System.currentTimeMillis();
                //get current time measured in milliseconds, between the current time and midnight, January 1, 1970 UTC
                Date date = new Date(millis); 
                //init current date
                Question q = new Question(qId, question, date, answers);
                HttpSession session = request.getSession(false);
                User user = (User) session.getAttribute("user");
                qDao.insertQuestion(q, user.getUserName());

                response.sendRedirect("managequiz");
            } else {
                request.setAttribute("mess", "Please choose at least 1 option and maximum 3 options!");
                request.getRequestDispatcher("/view/makequiz.jsp").forward(request, response);
            }
            }

        } catch (Exception e) {
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
        }

    }

    public boolean checkBoxValue(String value) {
        if (value == null) {
            //value of checkbox is null checked then return false
            return false;
        } else {
            //value of checkbox is not null checked then return true
            return value.equals("true");
        }
    }

    public boolean checkQuatityOfCheckBox(String op1, String op2, String op3, String op4) {
        int num = 0;
        if (checkBoxValue(op1)) {
            //check checkbox 1 is checked or not
            ++num;
        }
        if (checkBoxValue(op2)) {
            //check checkbox 2 is checked or not
            ++num;
        }
        if (checkBoxValue(op3)) {
            //check checkbox 3 is checked or not
            ++num;
        }
        if (checkBoxValue(op4)) {
            //check checkbox 4 is checked or not
            ++num;
        }
        return num >= 1 && num <= 3;
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

}
