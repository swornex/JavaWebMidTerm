package org.iims.controller;

import org.iims.dao.LoginDao;
import org.iims.dao.LoginDaoImpl;
import org.iims.model.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login-form.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            resp.sendRedirect("./");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        session.setAttribute("username", username);

        if (username.length() > 0 && password.length() > 0) {

            LoginDao loginDao = new LoginDaoImpl();
            try {
                Login login = loginDao.findOne(username, password);
                if (login != null) {
                    session.setAttribute("user", login);
                    resp.sendRedirect("./");
                    session.removeAttribute("username");
                    session.removeAttribute("error");
                } else {
                    session.setAttribute("error", "Sorry you're not registered.");
                    resp.sendRedirect("login");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            session.setAttribute("error", "Please input username or password.");
            resp.sendRedirect("login");
        }
    }
}
