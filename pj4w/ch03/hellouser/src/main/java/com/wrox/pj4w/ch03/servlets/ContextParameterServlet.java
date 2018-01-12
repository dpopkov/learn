package com.wrox.pj4w.ch03.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "contextParameterServlet",
        urlPatterns = {"/contextParameters"}
)
public class ContextParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        PrintWriter writer = resp.getWriter();

        writer.append("settingOne: ").append(context.getInitParameter("settingOne"))
                .append(", settingTwo: ").append(context.getInitParameter("settingTwo"));
    }
}
