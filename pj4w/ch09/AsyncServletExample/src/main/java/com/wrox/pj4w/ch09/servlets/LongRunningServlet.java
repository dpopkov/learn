package com.wrox.pj4w.ch09.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/longRunningServlet")
public class LongRunningServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        System.out.println("LongRunningServlet Start : " + threadInfo());

        String time = req.getParameter("time");
        int milliseconds;
        if (time == null || (milliseconds = Integer.parseInt(time)) > 10_000) {
            milliseconds = 10_000;
        }

        processing(milliseconds);

        long end = System.currentTimeMillis();
        resp.getWriter().write("Processing done for " + milliseconds + " milliseconds.");
        System.out.println("LongRunningServlet Finish : " + threadInfo() +
                ", time taken=" + (end - start) + " ms");
    }

    private void processing(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String threadInfo() {
        return "Name=" + Thread.currentThread().getName() + ", ID=" + Thread.currentThread().getId();
    }
}
