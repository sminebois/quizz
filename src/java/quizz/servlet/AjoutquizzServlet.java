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
@WebServlet(name = "AjoutquizzServlet", urlPatterns = {"/ajoutquizz"})
public class AjoutquizzServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ajoutquizz.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Question> lquestion = new ArrayList<Question>();
        lquestion.clear();
        
        
        Question q1 = new Question(req.getParameter("q1"), 0, req.getParameter("r1"), req.getParameter("r2"), req.getParameter("r3"), req.getParameter("r4"), Integer.parseInt(req.getParameter("nrep")));
        
        
        lquestion.add(q1);
        
        Quizz qu = new Quizz(req.getParameter("nom"));
        
                
        
        new QuestionService().enregistrerQuestion(q1);
        new QuizzService().enregisterQuizz(qu);
        
        q1.setLquizz(qu);
        qu.setLquestions(lquestion);
        
        new QuestionService().modifierQuestion(q1);
        new QuizzService().modifierQuizz(qu);
        
        
        resp.sendRedirect("home");
    }
    
    
}
