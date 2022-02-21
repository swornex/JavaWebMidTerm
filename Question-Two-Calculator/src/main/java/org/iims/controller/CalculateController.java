package org.iims.controller;

import org.iims.EvaluatePrefix;
import org.iims.InfixToPrefix;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="calculator", urlPatterns = "/calculator")
public class CalculateController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String expression = req.getParameter("expression");
        String prefixExpression = InfixToPrefix.infixToPrefix(" " + expression);
        double output = EvaluatePrefix.evaluatePrefix(prefixExpression);

        resp.setContentType("text/html");
        resp.getWriter().write("{ \"output\": \"" + output + "\" }");
    }
}
