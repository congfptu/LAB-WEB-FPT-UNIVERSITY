/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Answer;
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
public class AnsDAOTest {
    
    public AnsDAOTest() {
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
     * Test of getAnswers method, of class AnsDAO.
     */
   // 1 question sẽ có một list 4 đáp án \
    //normal 
    @Test  
    public void testGetAnswers() throws Exception {
        System.out.println("getAnswers");
        String qid = "szivhmzysb";
        AnsDAO instance = new AnsDAO();
        ArrayList<Answer> expResult =new ArrayList<Answer>();
        expResult.add(new Answer("flotomqaiv","1",false));
        expResult.add(new Answer("nhtwsrpnal","2",false));
        expResult.add(new Answer("vedpgcxevd","3",false));
        expResult.add(new Answer("ehlbbnnfxw","4",true));
        ArrayList<Answer> result = instance.getAnswers(qid);
        for (int i=0;i<result.size();i++)
        {
        assertEquals(expResult.get(i).getContent(), result.get(i).getContent());
        assertEquals(expResult.get(i).getId(), result.get(i).getId());
        assertEquals(expResult.get(i).isIsTrue(), result.get(i).isIsTrue());
        }
        // TODO review the generated test code and remove the default call to fail.
       
    }
     //Abnormal
    @Test
    public void testGetAnswers1() throws Exception {
        System.out.println("getAnswers");
        String qid = "12";
        AnsDAO instance = new AnsDAO();
        ArrayList<Answer> expResult =new ArrayList<Answer>();
      
        ArrayList<Answer> result = instance.getAnswers(qid);
        for (int i=0;i<result.size();i++)
        {
        assertEquals(expResult.get(i).getContent(), result.get(i).getContent());
        assertEquals(expResult.get(i).getId(), result.get(i).getId());
        assertEquals(expResult.get(i).isIsTrue(), result.get(i).isIsTrue());
        }
        // TODO review the generated test code and remove the default call to fail.
       
    }
    /**
     * Test of deleteAnswer method, of class AnsDAO.
     */
    //normal
    @Test
    public void testDeleteAnswer() throws Exception {
        System.out.println("deleteAnswer");
        String qid = "ggstuormio";
        AnsDAO instance = new AnsDAO();
        instance.deleteAnswer(qid);
        System.out.println("Delete Successfully");
    }
    //Abnormal
    @Test
    public void testDeleteAnswer1() throws Exception {
        System.out.println("deleteAnswer");
        String qid = "1234";
        AnsDAO instance = new AnsDAO();
        instance.deleteAnswer(qid);
        System.out.println("No data delete");
    }
    
    /**
     * Test of checkAnswerId method, of class AnsDAO.
     */
    //normal
    @Test
    public void testCheckAnswerId() throws Exception {
        System.out.println("checkAnswerId");
        String id = "flotomqaiv";
        AnsDAO instance = new AnsDAO();
        boolean expResult = true;
        boolean result = instance.checkAnswerId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.  
    }
    //abnormal
     @Test
    public void testCheckAnswerId2() throws Exception {
        System.out.println("checkAnswerId");
        String id = "1234";
        AnsDAO instance = new AnsDAO();
        boolean expResult = false;
        boolean result = instance.checkAnswerId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.  
    }
    


    /**
     * Test of insertAnswer method, of class AnsDAO.
     */
    //normal
    @Test
    public void testInsertAnswer() throws Exception {
        System.out.println("insertAnswer");
        Answer a = new Answer("abcdefghij","quyet thang",true);
        String qid = "tlkkzyehlc";
        AnsDAO instance = new AnsDAO();
        instance.insertAnswer(a, qid);
        // TODO review the generated test code and remove the default call to fail.
    }
   

    /**
     * Test of generateRandomIDs method, of class AnsDAO.
     */
    //normal
    @Test
    public void testGenerateRandomIDs() throws Exception {
        System.out.println("generateRandomIDs");
        int lengthOfId = 10;
        AnsDAO instance = new AnsDAO();
        String[] result = instance.generateRandomIDs(lengthOfId);
        for (int i=0;i<result.length;i++){
               assertEquals(10, result[i].length());
        }
        // TODO review the generated test code and remove the default call to fail.
    }
   
 
}
