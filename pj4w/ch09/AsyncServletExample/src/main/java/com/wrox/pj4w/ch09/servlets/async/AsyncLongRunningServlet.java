package com.wrox.pj4w.ch09.servlets.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

@WebServlet(urlPatterns = "/AsyncLongRunningServlet", asyncSupported = true)
public class AsyncLongRunningServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        System.out.println("AsyncLongRunningServlet Start : " + threadInfo());

        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);

        String time = req.getParameter("time");
        int milliseconds;
        if (time == null || (milliseconds = Integer.parseInt(time)) > 10_000) {
            milliseconds = 10_000;
        }

        AsyncContext asyncContext = req.startAsync();
        asyncContext.addListener(new AppAsyncListener());
        asyncContext.setTimeout(9_000);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) req.getServletContext().getAttribute("executor");

        executor.execute(new AsyncRequestProcessor(asyncContext, milliseconds));

        long end = System.currentTimeMillis();
        System.out.println("AsyncLongRunningServlet Finish : " + threadInfo() +
                ", time taken=" + (end - start) + " ms.");
    }

    private String threadInfo() {
        return "Name=" + Thread.currentThread().getName() + ", ID=" + Thread.currentThread().getId();
    }
}
