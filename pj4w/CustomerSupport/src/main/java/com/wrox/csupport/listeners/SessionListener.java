package com.wrox.csupport.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {
    private SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

    /* Methods of HttpSessionListener */

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(date() + ": Session " + se.getSession().getId() + " created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(date() + ": Session " + se.getSession().getId() + " destroyed");
    }

    /* Method of HttpSessionIdListener */
    @Override
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
        System.out.println(date() + ": Session ID " + oldSessionId + " changed to " + event.getSession().getId());
    }

    private String date() {
        return formatter.format(new Date());
    }
}
