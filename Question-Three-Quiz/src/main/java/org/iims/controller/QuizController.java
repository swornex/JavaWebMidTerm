package org.iims.controller;

import org.iims.dao.QuizDao;
import org.iims.dao.QuizDaoImpl;
import org.iims.model.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name="quiz", urlPatterns = "/quiz")
public class QuizController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("name")!=null ){
                session.setAttribute("name", req.getParameter("name"));
        }else{
            if(req.getParameter("name").toString().length()>0){
                session.setAttribute("name", req.getParameter("name"));
            }else {
                session.setAttribute("name", "Guest");
            }
        }
        if(session.getAttribute("score")== null) {
            session.setAttribute("score", 0);
        }

        QuizDao quizDao = new QuizDaoImpl();

        try{
            session.setAttribute("quizzes", quizDao.getQuestions());
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher= req.getRequestDispatcher("quiz.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Quiz> quizzes= (List<Quiz>) session.getAttribute("quizzes");
        int score = 0;

        for(Quiz quiz : quizzes){
            String answer = req.getParameter(String.valueOf(quiz.getId()));
            if(Objects.equals(answer, quiz.getCorrect_answer())){
                score++;
            }
        }

        session.setAttribute("score", score);
        resp.sendRedirect("quiz?name="+session.getAttribute("name") );
    }
}
