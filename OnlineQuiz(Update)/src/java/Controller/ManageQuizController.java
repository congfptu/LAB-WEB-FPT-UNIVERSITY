/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.TakeQuizDAO;
import Model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author congfptu
 */
public class ManageQuizController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            int totalPage = qDao.getTotalPage(5);
            //get total page with page size 
            int pageIndex = 1;
            //standard page index is 1
            String page_index = request.getParameter("page");
            if (page_index != null) {
                try {
                    pageIndex = Integer.parseInt(page_index);
                    //if page index > totalpage then error notification
                    if (totalPage < pageIndex||pageIndex<0) {
                        request.setAttribute("mess", "Not found");
                    }
                } catch (Exception ex) {
                    request.setAttribute("mess", "Not found");
                }
            }
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("number", qDao.countQuestion());
            ArrayList<Question> list = qDao.getQuestions(pageIndex, 5);
            request.setAttribute("questions", list);
            request.getRequestDispatcher("view/managequiz.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
        }

    }

    /**
     * s
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
        processRequest(request, response);
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
