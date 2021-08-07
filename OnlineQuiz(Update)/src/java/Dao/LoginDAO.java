/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author congfptu
 */
public class LoginDAO {

    //get user account by username and password
    public User getUser(String userName, String password) throws Exception {
        User user = null;
        DBContext db = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM [User] WHERE [userName]= ? AND [password]= ?";
            db = new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setString(1, userName);
            st.setString(2, password);
            rs = st.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIsTeacher(rs.getBoolean("isTeacher"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, st, rs);
        }
        return user;
    }

    //check username exist or not
    public boolean checkUsernameExist(String userName) throws Exception {

        boolean result = false;
        User user = null;
        DBContext db = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * from [User] where [userName]= ?";
            db = new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setString(1, userName);
            rs = st.executeQuery();
            while (rs.next()) {
                //loop to each item of the result set
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, st, rs);
        }

        return result;
    }
 public void insertUser(User u) throws Exception{

        Connection con = null;
        PreparedStatement st = null;
        DBContext db=null;
        try {
            String sql = "INSERT INTO [dbo].[User]\n"
                    + "           ([userName]\n"
                    + "           ,[password]\n"
                    + "           ,[email]\n"
                    + "           ,[isTeacher])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
          db=new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setString(1, u.getUserName());
            st.setString(2, u.getPassword());
            st.setString(3, u.getEmail());
            st.setBoolean(4, u.isIsTeacher());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection1(con, st);
        }

    }

    //message error if account information not correct
    public String checkUserAccount(String username, String password) throws Exception {
        if (!checkUsernameExist(username)) {
            //username is incorrect then
            return "Account is incorrect!";
        } else if (getUser(username, password) == null) {
            //password is incorrext
            return "Wrong password";
        }
        //username and password is correct
        return "";
    }
}
