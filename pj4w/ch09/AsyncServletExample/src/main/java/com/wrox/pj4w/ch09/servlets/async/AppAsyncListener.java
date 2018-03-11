package com.wrox.pj4w.ch09.servlets.async;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class AppAsyncListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("AppAsyncListener onComplete");
        // we can do resource cleanup here
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("AppAsyncListener onTimeout");
        // we can send appropriate response to client
        ServletResponse response = event.getAsyncContext().getResponse();
        response.getWriter().write("TimeOut Error in Processing");
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("AppAsyncListener onError");
        //we can return error response to client
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("AppAsyncListener onStartAsync");
        //we can log the event here
    }
}
