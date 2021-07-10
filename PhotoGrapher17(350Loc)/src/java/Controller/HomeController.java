package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.PhotoGrapherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Galery;
import model.Image;

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
      try{
           PhotoGrapherDAO photoDao = new PhotoGrapherDAO();
               int pageSize = 3;
            String pageIndex = request.getParameter("index");
              int index = 0;
            //check index page
            if (pageIndex != null) {
                try {
                    index = Integer.parseInt(pageIndex);
                } catch (Exception e) {
                    request.setAttribute("error", "This page is invalid!!");
                }
            }else{
                index = 1;
            }
           
            //count total result 
            int totalRecord = photoDao.count();
            int totalPages = totalRecord / pageSize;
            if ((totalRecord % pageSize) != 0) {
                totalPages++;
            }
            //get list galery with paging 
            List<Galery> digitalList = photoDao.getListGaleryWithPaging(index, pageSize);
            request.setAttribute("listGalery", digitalList);
            request.setAttribute("index", index);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("totalRecord", totalRecord);
           //get top 3 galery
            request.setAttribute("topGalery", photoDao.getTop3Galery());   
           //get contact infor
           request.setAttribute("contact", photoDao.getContact());
           request.setAttribute("active", "0");
           request.setAttribute("gap", getServletContext().getInitParameter("gap"));
           request.getRequestDispatcher("view/home.jsp").forward(request, response);
       }catch(Exception ex){
          request.setAttribute("error", ex); 
           request.getRequestDispatcher("common/error.jsp").forward(request, response);
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
        processRequest(request, response);
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
