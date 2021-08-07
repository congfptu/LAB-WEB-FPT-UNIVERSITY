/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class DBContextTest {
    
    public DBContextTest() {
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
     * Test of InitConfig method, of class DBContext.
     */            
    //normal 
    @Test
    public void testInitConfig() {
        System.out.println("InitConfig");
        DBContext instance = new DBContext();
        boolean expResult1=true;
        Connection result = instance.InitConfig1("sa","123456");
        assertEquals(expResult1, result!=null?true:false);
        // TODO review the generated test code and remove the default call to fail.
    }
    //Abnormal
    @Test
    public void testInitConfig1() {
        System.out.println("InitConfig");
        DBContext instance = new DBContext();
        boolean expResult1=false;
        Connection result = instance.InitConfig1("sa","12345");
        assertEquals(expResult1, result!=null?true:false);
        // TODO review the generated test code and remove the default call to fail.
    }

  
    
}
