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
        
        //récuperation de l'id du quizz     
        System.out.println("ID ******** " + req.getParameter("id"));
        System.out.println("QUIZZ *******" + req.getSession().getAttribute("id"));
        if(req.getSession().getAttribute("id") == null){
            qu = new QuizzService().getQuizzById(Long.parseLong(req.getParameter("id")));
            req.getSession().setAttribute("id", qu.getId());            
        }else{
            qu = new QuizzService().getQuizzById((long) req.getSession().getAttribute("id"));
            req.getSession().setAttribute("id", qu.getId());
        }
        req.setAttribute("quizz", qu);
        
        
        
                
        List<Question> lquestions = new QuestionService().getListQuestionByQuizzId(qu.getId());
        req.setAttribute("lquestions", lquestions);
        req.getSession().setAttribute("nbQuestion", lquestions.size() - 1);
        
        
        
        if(req.getSession().getAttribute("numQuestion") == null){
            req.getSession().setAttribute("numQuestion", 0);
        }        
        
        
        req.getRequestDispatcher("demarrer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   
        req.getSession().setAttribute("numQuestion", (int)req.getSession().getAttribute("numQuestion") + 1);
        
        if(req.getSession().getAttribute("numQuestion") == req.getSession().getAttribute("nbQuestion")){
            req.getSession().removeAttribute("numQuestion");
            req.getSession().removeAttribute("nbQuestion");
            req.getSession().removeAttribute("id");
            resp.sendRedirect("home");
        }else{       
            resp.sendRedirect("demarrer");
        }
        
    }
    
    
    
}
