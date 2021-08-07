/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Answer;
import Model.Question;
import java.sql.Date;
import java.util.ArrayList;
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
public class TakeQuizDAOTest {
    
    public TakeQuizDAOTest() {
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
     * Test of getQuestions method, of class TakeQuizDAO.
     */
    //normal
    @Test
    public void testGetQuestions_int_int() throws Exception {             
        System.out.println("getQuestions");
        int pageIndex = 1;
        int pageSize = 3;
        TakeQuizDAO instance = new TakeQuizDAO();
        ArrayList<Question> expResult = new ArrayList<>();
        expResult.add(new Question("fxjxrqswed", "SWE stand for", Date.valueOf("2021-06-11")));
        expResult.add(new Question("ggstuormio", "1+2=", Date.valueOf("2021-06-11")));
        expResult.add(new Question("szivhmzysb", "con cho co may chan", Date.valueOf("2021-06-11")));
        ArrayList<Question> result = instance.getQuestions(pageIndex, pageSize);
        for (int i=0;i<result.size();i++){
//            System.out.println(result.get(i).getId());
//            System.out.println(result.get(i).getContent());
//            System.out.println(result.get(i).getCreated());
              assertEquals(expResult.get(i).getId(), result.get(i).getId());
              assertEquals(expResult.get(i).getContent(), result.get(i).getContent());
              assertEquals(expResult.get(i).getCreated(), result.get(i).getCreated());
        }  
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of countQuestion method, of class TakeQuizDAO.
     */
    //normal
    @Test
    public void testCountQuestion() throws Exception {
        System.out.println("countQuestion");
        TakeQuizDAO instance = new TakeQuizDAO();
        int expResult = 9;
        int result = instance.countQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
      
    /**
     * Test of getTotalPage method, of class TakeQuizDAO.
     */      
    //normal
    @Test
    public void testGetTotalPage() throws Exception {
        System.out.println("getTotalPage");
        int pageSize = 3;
        TakeQuizDAO instance = new TakeQuizDAO();
        int expResult = 3;
        int result = instance.getTotalPage(pageSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail. 
    }
    //normal
     public void testGetTotalPage1() throws Exception {
        System.out.println("getTotalPage");
        int pageSize = 2;
        TakeQuizDAO instance = new TakeQuizDAO();
        int expResult = 5;
        int result = instance.getTotalPage(pageSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail. 
    }
    

    /**
     * Test of checkQuestionId method, of class TakeQuizDAO.
     */
    //normal
    @Test 
    public void testCheckQuestionId() throws Exception {
        System.out.println("checkQuestionId");
        String id = "fxjxrqswed";
        TakeQuizDAO instance = new TakeQuizDAO();
        boolean expResult = true;
        boolean result = instance.checkQuestionId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    //abnormal
     @Test
    public void testCheckQuestionId1() throws Exception {
        System.out.println("checkQuestionId");
        String id = "abc";
        TakeQuizDAO instance = new TakeQuizDAO();
        boolean expResult = false;
        boolean result = instance.checkQuestionId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getQuestions method, of class TakeQuizDAO.
     */
    @Test
    public void testGetQuestions_int() throws Exception {
        System.out.println("getQuestions");
        int number = 3;
        TakeQuizDAO instance = new TakeQuizDAO();
        int expResult = 3;
        ArrayList<Question> result = instance.getQuestions(number);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }
   

    /**
     * Test of deleteQuestion method, of class TakeQuizDAO.
     */
 
    @Test
    public void testDeleteQuestion() throws Exception {
        System.out.println("deleteQuestion");
        String qid = "tlkkzyehlc";
        TakeQuizDAO instance = new TakeQuizDAO();
        instance.deleteQuestion(qid);
//       AnsDAO ans=new AnsDAO();
//       int expectedResult=0;
//       int result=ans.getAnswers("qid").size();
//        assertEquals(expectedResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of insertQuestion method, of class TakeQuizDAO.
     */
    
    //normal
    @Test
    public void testInsertQuestion() throws Exception {
        System.out.println("insertQuestion");
        ArrayList<Answer> ans=new ArrayList<>();
        Question q = new Question("123456789a","1+1=?",Date.valueOf("2021-7-11"));
        Answer o1=new Answer("123456789b", "2", true);
        Answer o2=new Answer("123456789c", "3", false);
        Answer o3=new Answer("123456789d", "4", false);
        Answer o4=new Answer("123456789e", "5", false);      
        ans.add(o1);
        ans.add(o2);
        ans.add(o3);
        ans.add(o4);
        q.setAnswers(ans);
        String userName = "tuan";
        TakeQuizDAO instance = new TakeQuizDAO();
        instance.insertQuestion(q, userName);
 
    }
    //abnormal
    public void testInsertQuestion1() throws Exception {
        System.out.println("insertQuestion");
        ArrayList<Answer> ans=new ArrayList<>();
        Question q = new Question("123456789a","1+1=?",Date.valueOf("2021-7-11"));
        Answer o1=new Answer("123456789b", "2", true);
        Answer o2=new Answer("123456789c", "3", false);
        Answer o3=new Answer("123456789d", "4", false);
        Answer o4=new Answer("123456789e", "5", false);      
        ans.add(o1);
        ans.add(o2);
        ans.add(o3);
        ans.add(o4);
        q.setAnswers(ans);
        String userName = "tuan";
        TakeQuizDAO instance = new TakeQuizDAO();
        instance.insertQuestion(q, userName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of generateRandomID method, of class TakeQuizDAO.
     */
//  
//    @Test
//    public void testGenerateRandomID() throws Exception {
//        System.out.println("generateRandomID");
//        int length = 10;
//        TakeQuizDAO instance = new TakeQuizDAO();
//        String expResult = "";
//        String result = instance.generateRandomID(length);
//        assertEquals(10, result.length());
//        
//    }
//    
}
