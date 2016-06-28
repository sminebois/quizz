/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.dao;

import java.util.List;
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

    public int getOrdreDerniereQuestionByQuizz(long idquizz){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        List<Question> lq = em.createQuery("SELECT q FROM Question q WHERE q.lquizz.id=:idq ORDER BY q.ordre DESC").setParameter("idq", idquizz).getResultList();
        if(lq.isEmpty()){
            return 0;
        }
        return lq.get(0).getOrdre();
    }
}
