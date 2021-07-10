/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author congfptu
 */
public class User {
    private String userName;
    private String password;
    private String email;
    private boolean isTeacher;
    private List<Question> questions;

    public User() {
    }

    public User(String userName, String password, String email, boolean isTeacher) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isTeacher = isTeacher;
    }

    public User(String userName, String password, String email,
            boolean isTeacher, List<Question> questions) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isTeacher = isTeacher;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(boolean isTeacher) {
        this.isTeacher = isTeacher;
    }
    
}
