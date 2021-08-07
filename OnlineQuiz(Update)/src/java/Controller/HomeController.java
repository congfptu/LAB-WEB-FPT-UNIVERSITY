/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.LoginDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author congfptu
 */
public class HomeController extends HttpServlet {

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
            out.println("<title>Servlet HomeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
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
            HttpSession session = request.getSession();
            //if exist user then send redirect to home
            if (session.getAttribute("user") != null) {
                request.getRequestDispatcher("view/home.jsp").forward(request, response);
            } else {
                //user has not already exsited in session then send redirect to login 
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
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
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            HttpSession session = request.getSession();
            LoginDAO db = new LoginDAO(); 
            String checkAccount=db.checkUserAccount(userName, password);
            if (checkAccount.isEmpty()) {
                //if username and password is correct then get user by username and password
                User user = db.getUser(userName, password);
                session.setAttribute("user", user);
                response.sendRedirect("home");
            } else {
                //if username or password is incorrect then response message error 
                request.setAttribute("mess", checkAccount);
                request.getRequestDispatcher("/view/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
