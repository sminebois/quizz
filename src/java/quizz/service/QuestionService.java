/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.service;

import quizz.dao.QuestionDAO;
import quizz.entity.Question;

/**
 *
 * @author admin
 */
public class QuestionService {
    public void enregistrerQuestion(Question qu){
        new QuestionDAO().ajouterQuestion(qu);
    }
    
    public void modifierQuestion(Question qu){
        new QuestionDAO().modifierQuestion(qu);
    }
}
