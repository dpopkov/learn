package com.wrox.csupport.sessions;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
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
        HttpSession session = se.getSession();
        SessionRegistry.addSession(session);
        System.out.println(date() + ": Session " + session.getId() + " created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        SessionRegistry.removeSession(session);
        System.out.println(date() + ": Session " + session.getId() + " destroyed");
    }

    /* Method of HttpSessionIdListener */
    @Override
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
        HttpSession session = event.getSession();
        SessionRegistry.updateSessionId(session, oldSessionId);
        System.out.println(date() + ": Session ID " + oldSessionId + " changed to " + session.getId());
    }

    private String date() {
        return formatter.format(new Date());
    }
}
