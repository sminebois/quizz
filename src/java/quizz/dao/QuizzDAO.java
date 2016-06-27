/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import quizz.entity.Quizz;

/**
 *
 * @author admin
 */
public class QuizzDAO {
    public void ajouterQuestion(Quizz qu){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(qu);
        em.getTransaction().commit();
    }
    
    public void modifierQuestion(Quizz qu){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(qu);
        em.getTransaction().commit();
    }
    
    public Quizz getQuizzById(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Quizz.class, id);
    }
}
