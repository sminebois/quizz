/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import quizz.entity.Question;

/**
 *
 * @author admin
 */
public class QuestionDAO {
    public void ajouterQuestion(Question ques){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(ques);
        em.getTransaction().commit();
    }
    
    public void modifierQuestion(Question q){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(q);
        em.getTransaction().commit();
    }
}
