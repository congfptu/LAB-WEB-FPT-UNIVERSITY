/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Model.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author congfptu
 */
public class AccessPermissions implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String url = req.getRequestURI();
        if (url.contains("make") || url.contains("manage") || url.contains("delete")) {
              User user = (User) session.getAttribute("user");
            //user access to makequiz or managequiz
            if (user.isIsTeacher()) {
                //user has role is teacher is allowed to access
                chain.doFilter(request, response);
            } else {
                //user has role is student is not allowed to access
                req.setAttribute("mess", "This function is only for teachers!");
                req.getRequestDispatcher("/view/home.jsp").forward(request, response);
            }            
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
     
    }
    
}
