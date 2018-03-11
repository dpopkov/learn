package com.wrox.pj4w.ch09.servlets.async;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 200, 50_000L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));

        sce.getServletContext().setAttribute("executor", executor);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) sce.getServletContext().getAttribute("executor");
        executor.shutdown();
    }
}
