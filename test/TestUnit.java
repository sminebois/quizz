/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import quizz.dao.QuestionDAO;
import quizz.entity.Question;

/**
 *
 * @author admin
 */
public class TestUnit {
    
    @Test
    public void test1(){
        QuestionDAO qd = new QuestionDAO();
        
        System.out.println(qd.getOrdreDerniereQuestionByQuizz(1));
    }
    
    @Before
    public void bf()
    {
        System.out.println("**********************");
    }
    @After
    public void af(){
        System.out.println("-------------------");
    }
}
