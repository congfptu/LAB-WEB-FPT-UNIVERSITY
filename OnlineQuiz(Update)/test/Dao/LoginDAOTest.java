/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author congfptu
 */
public class LoginDAOTest {
    
    public LoginDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUser method, of class LoginDAO.
     */
    //normal
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String userName = "tuan";
        String password = "123";
        
        String email = "tuanvm@fpt.edu.vn";
        boolean isTeacher = true;
        LoginDAO instance = new LoginDAO();
        User expResult = new User(userName, password, email,true);
        User result = instance.getUser(userName, password);
        assertEquals(expResult.getUserName(), result.getUserName());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.isIsTeacher(), result.isIsTeacher());
        // TODO review the generated test code and remove the default call to fail.
    
    }
    //abnormal
     @Test
    public void testGetUser1() throws Exception {
        System.out.println("getUser");
        String userName = "tuan";
        String password = "1233456";
        String email = "tuanvm@fpt.edu.vn";
        boolean isTeacher = true;
        LoginDAO instance = new LoginDAO();
        User expResult = null;
        User result = instance.getUser(userName, password);
        assertEquals(expResult, result);
     
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of checkUsernameExist method, of class LoginDAO.
     */
    //normal
    @Test
    public void testCheckUsernameExist() throws Exception {
        System.out.println("checkUsernameExist");
        String userName = "tuan";
        LoginDAO instance = new LoginDAO();
        boolean expResult = true;
        boolean result = instance.checkUsernameExist("tuan");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    //Abnormal
    public void testCheckUsernameExist1() throws Exception {
        System.out.println("checkUsernameExist");
        String userName = "abc";
        LoginDAO instance = new LoginDAO();
        boolean expResult = false;
        boolean result = instance.checkUsernameExist("tuan");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    

    /**
     * Test of insertUser method, of class LoginDAO.
     */
    
    //normal
    @Test
    public void testInsertUser() throws Exception {
        System.out.println("insertUser");
        User u = new User("sa10 ", "123456","fpt", true);
        LoginDAO instance = new LoginDAO();
        instance.insertUser(u);
    }
    //Abnormal
    @Test
    public void testInsertUser1() throws Exception {
        System.out.println("insertUser");
        User u = new User("s10", "123456","fpt", true);
        LoginDAO instance = new LoginDAO();
        instance.insertUser(u);
    }

    /**
     * Test of checkUserAccount method, of class LoginDAO.
     */
    //normal
    @Test
    public void testCheckUserAccount() throws Exception {
        System.out.println("checkUserAccount");
        String username = "tuan";
        String password = "123";
        LoginDAO instance = new LoginDAO();
        String expResult = "";
        String result = instance.checkUserAccount(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
     //Abnormal
    @Test
    public void testCheckUserAccount1() throws Exception {
        System.out.println("checkUserAccount");
        String username = "tuan123";
        String password = "123";
        LoginDAO instance = new LoginDAO();
        String expResult = "Account is incorrect!";
        String result = instance.checkUserAccount(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
     //Abnormal
    @Test
    public void testCheckUserAccount2() throws Exception {
        System.out.println("checkUserAccount");
        String username = "tuan";
        String password = "12344556";
        LoginDAO instance = new LoginDAO();
        String expResult = "Wrong password";
        String result = instance.checkUserAccount(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
   
    
}
