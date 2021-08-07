/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author congfptu
 */
public class AnsDAO {

    public ArrayList<Answer> getAnswers(String qid) throws Exception {

        ArrayList<Answer> list = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        DBContext db = null;
        try {
            db = new DBContext();
            list = new ArrayList<>();
            String sql = "SELECT * FROM Answer WHERE qid= ?";
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setString(1, qid);
            rs = st.executeQuery();
            while (rs.next()) {
                //loop to each item of the result set
                Answer ans = new Answer();
                ans.setId(rs.getString("aid"));
                ans.setContent(rs.getString("content"));
                ans.setIsTrue(rs.getBoolean("isTrue"));
                list.add(ans);
            }
               
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, st, rs);
        }
        return list;
     
    }

    /**
     *
     * @param qid
     * @throws java.lang.Exception
     */
    public void deleteAnswer(String qid) throws Exception {

        Connection con = null;
        PreparedStatement st = null;
        DBContext db = null;
        try {
            String sql = "DELETE FROM Answer WHERE qid = ?";
            db = new DBContext();
            con = db.InitConfig();
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

    public boolean checkAnswerId(String id) throws Exception {
        boolean result = false;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        DBContext db = null;
        try {
            String sql = "SELECT * FROM Answer WHERE aid = ?\n";
            db = new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setString(1, id);
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

    /**
     *
     * @param a
     * @param qid
     * @throws java.lang.Exception
     */
    public void insertAnswer(Answer a, String qid) throws Exception {
        Connection con = null;
        PreparedStatement st = null;
        DBContext db = null;
        try {
            String sql = "INSERT INTO [dbo].[Answer]\n"
                    + "           ([aid]\n"
                    + "           ,[qid]\n"
                    + "           ,[content]\n"
                    + "           ,[isTrue])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            db = new DBContext();
            con = db.InitConfig();
            st = con.prepareStatement(sql);
            st.setString(1, a.getId());
            st.setString(2, qid);
            st.setString(3, a.getContent());
            st.setBoolean(4, a.isIsTrue());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection1(con, st);
        }
    }

   public String[] generateRandomIDs(int lengthOfId) throws Exception {
         Random rand = new Random();
        String str = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(lengthOfId);
        HashSet<String> aIds = new HashSet();
        //hashet for each element is difference
        String[] rs = new String[4];
        //init array string with 4 elements cause question has 4 answer
        while (aIds.size() != 4) {
            //loop to answer id list has all 4 ids
            for (int i = 0; i < lengthOfId; i++) {
                //loop from 0 to length of answer id
                sb.append(str.charAt(rand.nextInt(str.length())));
            }
            if (!checkAnswerId(sb.toString())) {
                //to check id is unique in database
                aIds.add(sb.toString());
                //add to answer id list 
                sb.setLength(0);
                //set string builder length is 0 for next turn
            }
        }
        return aIds.toArray(rs);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
