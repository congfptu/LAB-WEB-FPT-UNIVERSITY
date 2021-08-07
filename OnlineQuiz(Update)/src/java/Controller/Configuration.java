/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DBContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author congfptu
 */
public class Configuration implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.out.println("online quizzzz");
            InitialContext init = new InitialContext();
            Context ctx = (Context) init.lookup("java:/comp/env");
            String connectionUrl =(String)ctx.lookup("dbURL");
            String username =(String)ctx.lookup("dbUsername");
            String password = (String) ctx.lookup("dbPassword");
            
            DBContext.connectionUrl=connectionUrl;
            DBContext.username=username;
            DBContext.password=password;
          
        } catch (Exception ex) {
            try {
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       
    }
    
}
