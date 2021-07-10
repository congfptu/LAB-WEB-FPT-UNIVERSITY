/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.News;

/**
 *
 * @author congfptu
 */
public class NewsDAO {
    
//get top x recent news
    public List<News> getRecentNews(int numberNews) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<News> results = new ArrayList<>();
        String sql = "SELECT TOP(?) * \n"
                + "FROM News\n"
                + "ORDER BY date DESC";
        try {
            db = new DBContext();
            con = db.InitConfig();
            statement = con.prepareStatement(sql);
            statement.setInt(1, numberNews);
            rs = statement.executeQuery();
            while (rs.next()) {
                News model = new News();
                model.setId(rs.getInt("id"));
                model.setTitle(rs.getString("title"));
                model.setContent(rs.getString("content"));
                model.setDate(rs.getTimestamp("date"));
                model.setWriter(rs.getString("writer"));
                results.add(model);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, statement, rs);
        }
        return results;
    }
    
//find news by id
    public News findById(int id) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        News model = new News();
        String sql = "SELECT * FROM News WHERE id = ?";
        try {
            db = new DBContext();
            con = db.InitConfig();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                model.setId(rs.getInt("id"));
                model.setTitle(rs.getString("title"));
                model.setContent(rs.getString("content"));
                model.setDate(rs.getTimestamp("date"));
                model.setWriter(rs.getString("writer"));
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, statement, rs);
        }
        return model;

    }
    
//count total news find by keyword
    public int countSearchPage(String keyword) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select count(*)as total from News\n"
                + "    WHERE title LIKE ? OR content LIKE ?";
        try {
            db = new DBContext();
            con = db.InitConfig();
            statement = con.prepareStatement(sql);
            keyword = "%" + keyword + "%";
            statement.setString(1, keyword);
            statement.setString(2, keyword);
            rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, statement, rs);
        }
        return 0;
    }

//search news by keyword and Pagination of found news
    public List<News> searchByKeyWord(String keyword, int pageindex, int pagesize) throws Exception {
        DBContext db = null;
        Connection con = null;
        Exception e=null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<News> results = new ArrayList<>();
        String sql = "  select*from(select ROW_NUMBER() OVER(order by a.date desc)"
                    + " as rid,a.id,a.title,a.content,a.date,a.writer,a.images from News a \n"
                    + "      where a.title like ? OR content like ?)app\n"
                    + "      where  app.rid>=? and rid<=?";
        try {
            db = new DBContext();
            con = db.InitConfig();
            statement = con.prepareStatement(sql);
            keyword = "%" + keyword + "%";
            statement.setString(1, keyword);
            statement.setString(2, keyword);
            //begin and end of pageindex 
            int begin = (pageindex - 1) * pagesize + 1;
            int end = pageindex * pagesize;
            statement.setInt(3, begin);
            statement.setInt(4, end);
            rs = statement.executeQuery();
            while (rs.next()) {
                News model = new News();
                model.setId(rs.getInt("id"));
                model.setTitle(rs.getString("title"));
                model.setContent(rs.getString("content"));
                model.setDate(rs.getTimestamp("date"));
                model.setWriter(rs.getString("writer"));
                model.setImages(rs.getString("images"));
                results.add(model);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {     
            db.closeConnection(con, statement, rs);
        }
        return results;
    }

//    public static void main(String[] args) throws Exception {
//        NewsDAO db = new NewsDAO();
//        db.getRecentNews(1);
//    }
}
