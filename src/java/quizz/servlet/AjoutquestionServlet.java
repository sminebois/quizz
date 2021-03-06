/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AjoutquestionServlet", urlPatterns = {"/ajoutquestion"})
public class AjoutquestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nquestion", req.getSession().getAttribute("nb"));
        List<Quizz> lquizz = new QuizzService().getListeQuizz();
        req.setAttribute("lquizz", lquizz);
        
        req.getRequestDispatcher("ajoutquestion.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Quizz qu = (Quizz) req.getSession().getAttribute("quizzz");
        
        if(qu == null){
            qu = new QuizzService().getQuizzById(Long.parseLong(req.getParameter("quizzSel")));
        }
        
        List<Question> lquestion = new ArrayList<>();
        
        Question q1 = new Question(req.getParameter("q1"), new QuestionService().getOrdreDerniereQuestionByQuizz(qu.getId()) + 1, req.getParameter("r1"), req.getParameter("r2"), req.getParameter("r3"), req.getParameter("r4"), Integer.parseInt(req.getParameter("nrep")), qu);
        
        
        
        lquestion.add(q1);
        qu.setLquestions(lquestion);
        
        new QuestionService().enregistrerQuestion(q1);
        new QuizzService().modifierQuizz(qu);
        
        
        resp.sendRedirect("home");
    }
}
