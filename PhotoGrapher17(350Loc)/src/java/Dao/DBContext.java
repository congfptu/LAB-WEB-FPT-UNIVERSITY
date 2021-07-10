/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;

public class DBContext {
public static String connectionUrl;
public static String username;
public static String password;
public static String image;

    public DBContext() {
       
    }
     public Connection getConnection() throws Exception {
         try {      
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection connection = DriverManager.getConnection(connectionUrl, username, password);
            return connection;
        } catch (Exception ex) {
         throw ex;
        }
    } 
//      public Connection getConnection() {
//         try {       
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=photo";
//            String username = "sa";
//            String password = "123456";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            return DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         return null;
//    } 
    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws Exception {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
     public void closeConnection1(Connection con, PreparedStatement ps) throws Exception {
       
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
      public String getImagePath() throws Exception {
        return DBContext.image;
    }
   
}
