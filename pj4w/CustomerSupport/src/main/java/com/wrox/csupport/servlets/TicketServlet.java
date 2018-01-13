package com.wrox.csupport.servlets;

import com.wrox.csupport.model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(
        name = "ticketServlet",
        urlPatterns = {"/tickets"},
        loadOnStartup = 1
)
public class TicketServlet extends HttpServlet {
    private Map<Integer, Ticket> ticketDatabase = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
            default:
                listTickets(resp);
                break;
        }
    }

    private void listTickets(HttpServletResponse resp) throws IOException {
        PrintWriter writer = writeHeader(resp);

        writer.append("<h2>Tickets</h2>\r\n");
        writer.append("<a href=\"tickets?action=create\">Create Ticket").append("</a><br/><br/>\r\n");

        if (ticketDatabase.size() == 0) {
            writer.append("<i>There are no tickets in the system.</i>\r\n");
        } else {
            for (int id : ticketDatabase.keySet()) {
                String idString = Integer.toString(id);
                Ticket ticket = ticketDatabase.get(id);
                writer.append("Ticket #").append(idString)
                        .append(": <a href=\"tickets?action=view&ticketId=").append(idString).append("\">")
                        .append(ticket.getSubject())
                        .append("</a>")
                        .append(" (customer): ").append(ticket.getCustomerName()).append(")<br/>\r\n");
            }
        }

        writeFooter(writer);
    }

    private PrintWriter writeHeader(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("    <head>\r\n")
                .append("        <title>Customer Support</title>\r\n")
                .append("    </head>\r\n")
                .append("    <body>\r\n");
        return writer;
    }

    private void writeFooter(PrintWriter writer) {
        writer.append("    </body>\r\n").append("</html>\r\n");
    }
}
