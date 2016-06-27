/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.service;

import quizz.dao.QuizzDAO;
import quizz.entity.Quizz;

/**
 *
 * @author admin
 */
public class QuizzService {
    public void enregisterQuizz(Quizz qu){
        new QuizzDAO().ajouterQuestion(qu);
    }
    
    public void modifierQuizz(Quizz qu){
        new QuizzDAO().modifierQuestion(qu);
    }
    
    public Quizz getQuizzById(long id){
        return new QuizzDAO().getQuizzById(id);
    }
}
