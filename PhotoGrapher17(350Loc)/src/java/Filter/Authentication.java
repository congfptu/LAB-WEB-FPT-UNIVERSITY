/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import com.sun.glass.events.ViewEvent;
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
public class Authentication implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            
            String contextPath = req.getContextPath();
            //get servlet path (path after context path)
            String url = req.getServletPath();
            if (url.endsWith(".jsp")) {
                if (url.equals("/view/home.jsp")) {
                    res.sendRedirect(contextPath+"/home");
                } 
                else if (url.equals("/view/gallery.jsp")) {
                    res.sendRedirect(contextPath+"/gallery"); 
                } 
                else if (url.equals("/view/contact.jsp")) {
                    res.sendRedirect(contextPath+"/contact");    
                } 
                else {
                    res.sendRedirect(contextPath+"/home");
                }   
            } else{
                chain.doFilter(request, response);
            }       
        } catch (Exception ex) {
            ex.printStackTrace();
            req.getRequestDispatcher("common/error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
