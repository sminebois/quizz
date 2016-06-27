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
import quizz.entity.Quizz;
import quizz.service.QuizzService;

/**
 *
 * @author admin
 */
@WebServlet(name = "QuizzServlet", urlPatterns = {"/quizz"})
public class QuizzServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Quizz> lquizz = new QuizzService().getListeQuizz();
        req.setAttribute("lquizz", lquizz);
        
        req.getRequestDispatcher("quizz.jsp").forward(req, resp);        
    }
    
}
