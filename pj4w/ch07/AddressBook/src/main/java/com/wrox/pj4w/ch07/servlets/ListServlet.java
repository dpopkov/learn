package com.wrox.pj4w.ch07.servlets;

import com.wrox.pj4w.ch07.model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.util.*;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static final SortedSet<Contact> contacts = new TreeSet<>();

    static {
        contacts.add(new Contact("Jane", "Sanders", "555-1593", "394 E 22nd Ave",
                MonthDay.of(Month.JANUARY, 5),
                Instant.parse("2013-02-01T15:22:23Z")
        ));
        contacts.add(new Contact( "John", "Smith", "555-0712", "315 Maple St",
                null, Instant.parse("2012-10-15T09:31:17Z")
        ));
        contacts.add(new Contact("Scott", "Johnson", "555-9834", "424 Oak Dr",
                MonthDay.of(Month.NOVEMBER, 17),
                Instant.parse("2013-04-04T19:45:01Z")
        ));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("language");
        if ("french".equalsIgnoreCase(language)) {
            Config.set(req, Config.FMT_LOCALE, Locale.FRANCE);
        }
        if (req.getParameter("empty") != null) {
            req.setAttribute("contacts", Collections.<Contact>emptySet());
        } else {
            req.setAttribute("contacts", contacts);
        }
        req.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp").forward(req, resp);
    }
}
