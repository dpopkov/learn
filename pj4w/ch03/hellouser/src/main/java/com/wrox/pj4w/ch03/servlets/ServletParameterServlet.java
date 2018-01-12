package com.wrox.pj4w.ch03.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        PrintWriter writer = resp.getWriter();

        writer.append("database: ").append(config.getInitParameter("database"))
                .append(", server: ").append(config.getInitParameter("server"));
    }
}
