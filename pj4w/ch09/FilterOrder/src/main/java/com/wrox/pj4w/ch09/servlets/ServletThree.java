package com.wrox.pj4w.ch09.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "servletThree",
        urlPatterns = {"/servletThree"}
)
public class ServletThree extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entering ServletThree.doGet()");
        resp.getWriter().write("Servlet Three");
        System.out.println("Leaving ServletThree.doGet()");
    }
}
