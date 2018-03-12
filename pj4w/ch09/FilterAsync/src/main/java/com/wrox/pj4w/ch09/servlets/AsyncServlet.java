package com.wrox.pj4w.ch09.servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "asyncServlet",
        urlPatterns = "/async",
        asyncSupported = true
)
public class AsyncServlet extends HttpServlet {
    private static volatile int ID = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int id;
        synchronized (AsyncServlet.class) {
            id = ID++;
        }
        long timeout = req.getParameter("timeout") == null ?
                10_000L : Long.parseLong(req.getParameter("timeout"));

        logInfo("Entering AsyncServlet.doGet(). Request ID = " + id +
                ", isAsyncStarted = " + req.isAsyncStarted());

        final AsyncContext context = req.getParameter("unwrap") != null ?
                req.startAsync() : req.startAsync(req, resp);
        context.setTimeout(timeout);

        logInfo("Starting asynchronous thread. Request ID = " + id + ".");

        AsyncThread thread = new AsyncThread(id, context);
        context.start(thread::doWork);

        logInfo("Leaving AsyncServlet.doGet(). Request ID = " + id +
                ", isAsyncStarted = " + req.isAsyncStarted());
    }

    private class AsyncThread {
        private final int id;
        private final AsyncContext context;

        public AsyncThread(int id, AsyncContext context) {
            this.id = id;
            this.context = context;
        }

        public void doWork() {
            logInfo("Asynchronous thread started. Request ID = " + id + ".");
            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            logInfo("Done sleeping. Request ID = " + id + ", URL = " + request.getRequestURI() + ".");

            context.dispatch("/WEB-INF/jsp/view/async.jsp");

            logInfo("Asynchronous thread completed. Request ID = " + id + ".");
        }
    }

    private void logInfo(String s) {
        System.out.println(threadName() + s);
    }

    private synchronized String threadName() {
        return Thread.currentThread().getName() + ": ";
    }
}
