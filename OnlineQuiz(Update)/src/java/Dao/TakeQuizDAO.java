/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Answer;
import Model.Question;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author congfptu
 */
public class TakeQuizDAO {
  ///get question by pageindex pagesize
    public ArrayList<Question> getQuestions(int pageIndex, int pageSize) throws Exception {

        ArrayList<Question> list = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        DBContext db = null;
        try {
            list = new ArrayList<>();
            String sql = " select*from(select ROW_NUMBER() OVER(order by created) as rid, * from Question a ) g\n"
                    + " where rid>=? and rid<=?";
            db = new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            int begin = (pageIndex - 1) * pageSize + 1;
            int end = pageIndex * pageSize;
            st.setInt(1, begin);
            st.setInt(2, end);
            rs = st.executeQuery();
            while (rs.next()) {
                Question q=new Question();
                q.setId(rs.getString("qid"));
                q.setContent(rs.getString("content"));
                q.setCreated(rs.getDate("created"));
                list.add(q);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, st, rs);
        }
        return list;
    }

   
    //count number of question 
    public int countQuestion() throws Exception {
        int num = 0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        DBContext db = null;
        try {
            String sql = "SELECT COUNT(qid) AS NumberOfQuestion FROM Question";
            db = new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                //loop to each item of the result set
                num = rs.getInt("NumberOfQuestion");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, st, rs);
        }
        return num;
    }
    //get total page by number of questions and page size
    public int getTotalPage(int pageSize) throws Exception {
        int total = countQuestion();
        if (total % pageSize == 0) {
            //return number of page when total % pageSize
            return total / pageSize;
        } else {
            //return number of page when total % pageSize then add to 1
            return (total / pageSize) + 1;
        }
    }
    //check question if exist or not
     public boolean checkQuestionId(String id) throws Exception {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        DBContext db = null;

        try {
            String sql = "SELECT * FROM Question WHERE qid = ?\n";
            db = new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, st, rs);
        }
        return false;
    }

  //get random "number" question 
    public ArrayList<Question> getQuestions(int number) throws Exception {

        ArrayList<Question> list = null;
        ArrayList<Answer> answerList = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        DBContext db = null;
        AnsDAO ans = new AnsDAO();
        try {
            list = new ArrayList<>();
            String sql = "SELECT TOP (?) *from Question ORDER BY NEWID()";
            db = new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setInt(1, number);
            rs = st.executeQuery();
            while (rs.next()) {
                //loop to each item of the result set
                String qid = rs.getString("qid");
                String content=rs.getString("content");
                Date date= rs.getDate("created");
                Question q = new Question();
                q.setId(qid);
                q.setContent(content);
                q.setCreated(date);
                answerList = ans.getAnswers(qid);
                //get all answers of that question follow qid
                q.setAnswers(answerList);
                list.add(q);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, st, rs);
        }
        return list;
    }

   //delete question 
    public void deleteQuestion(String qid) throws Exception {

        Connection con = null;
        PreparedStatement st = null;
        DBContext db = null;
        AnsDAO ans = new AnsDAO();
        try {
            db = new DBContext();
            con = db.InitConfig();
            String sql = "DELETE FROM Question WHERE qid = ?";
            ans.deleteAnswer(qid);
            st = con.prepareStatement(sql);
            st.setString(1, qid);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection1(con, st);
        }
    }

    //insert question into database
    public void insertQuestion(Question q, String userName) throws Exception {
        Connection con = null;
        PreparedStatement st = null;
        DBContext db = null;
        AnsDAO ans = new AnsDAO();
        try {
             String sql = "INSERT INTO [dbo].[Question]\n"
                    + "           ([qid]\n"
                    + "           ,[userName]\n"
                    + "           ,[content]\n"
                    + "           ,[created])\n"
                    + "     VALUES\n"
                    + "             (?,\n"
                    + "              ?,\n"
                    + "              ?,\n"
                    + "              ?)";
            db=new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setString(1, q.getId());
            st.setString(2, userName);
            st.setString(3, q.getContent());
            st.setDate(4, q.getCreated());
            st.executeUpdate();
            for (Answer answer : q.getAnswers()) {
                //insert each answer of that question to database
                ans.insertAnswer(answer, q.getId());
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection1(con, st);
        }
    }
    
 public String generateRandomID(int length) throws Exception {
        Random rand = new Random();
        String str = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        String rs = "";
        while (true) {
            for (int i = 0; i < length; i++) {
                //loop from 0 to length of question id
                sb.append(str.charAt(rand.nextInt(str.length())));
            }
            rs = sb.toString();
            try {
                if (!checkQuestionId(rs)) {
                    //to check id is unique in database
                    break;
                }
            } catch (Exception e) {
                throw e;
            }

        }
        return rs;
    }

   
}
