/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quizz.entity.Question;
import quizz.entity.Quizz;
import quizz.service.QuestionService;
import quizz.service.QuizzService;

/**
 *
 * @author admin
 */
@WebServlet(name = "DemarrerServlet", urlPatterns = {"/demarrer"})
public class DemarrerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Quizz qu = new Quizz();
        
        //récuperation de l'id du quizz + attribution du paramètre quizz
        if(req.getSession().getAttribute("id") == null){
            qu = new QuizzService().getQuizzById(Long.parseLong(req.getParameter("id")));
            req.getSession().setAttribute("id", qu.getId());            
        }else{
            qu = new QuizzService().getQuizzById((long) req.getSession().getAttribute("id"));
            req.getSession().setAttribute("id", qu.getId());
        }
        req.setAttribute("quizz", qu);
        
        
        
        //récuperation de la liste de question + nb de questions        
        List<Question> lquestions = new QuestionService().getListQuestionByQuizzId(qu.getId());
        req.setAttribute("lquestions", lquestions);
        req.getSession().setAttribute("nbQuestion", lquestions.size() - 1);
        
        
        //initialisation du numéro de la question actuelle en cas de début du quizz
        if(req.getSession().getAttribute("numQuestion") == null){
            req.getSession().setAttribute("numQuestion", 0);
        }        
        //initialisation du score en début de quizz
        if(req.getSession().getAttribute("scoretotal") == null){
            req.getSession().setAttribute("scoretotal", 0);
        }
        
        
        
        req.getRequestDispatcher("demarrer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   
        long lg = Long.parseLong(req.getParameter("idqu"));
        Question q = new QuestionService().getQuestionByID(lg);
        //vérif de la réponse + incrémentation du score
        if(Long.parseLong(req.getParameter("choix")) == q.getNumRep()){
            req.getSession().setAttribute("scoretotal", (int)req.getSession().getAttribute("scoretotal") + 1);
        }
        
        
        //redirection si il ne reste plus de question, sinon rappel de la page
        if(req.getSession().getAttribute("numQuestion") == req.getSession().getAttribute("nbQuestion")){
            req.getSession().removeAttribute("numQuestion");
            req.getSession().removeAttribute("id");
            resp.sendRedirect("score");
        }else{       
            req.getSession().setAttribute("numQuestion", (int)req.getSession().getAttribute("numQuestion") + 1);//numéro de la question ++
            resp.sendRedirect("demarrer");
        }
        
    }
    
    
    
}
