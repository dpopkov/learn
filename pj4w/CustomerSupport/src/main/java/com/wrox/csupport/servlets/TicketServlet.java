package com.wrox.csupport.servlets;

import com.wrox.csupport.model.Attachment;
import com.wrox.csupport.model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(
        name = "ticketServlet",
        urlPatterns = {"/tickets"},
        loadOnStartup = 1
)
@MultipartConfig(
        fileSizeThreshold = 5_242_880, //5MB
        maxFileSize = 20_971_520L, //20MB
        maxRequestSize = 41_943_040L //40MB
)
public class TicketServlet extends HttpServlet {
    private volatile int TICKET_ID_SEQUENCE = 1;

    private Map<Integer, Ticket> ticketDatabase = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "create":
                showTicketForm(resp);
                break;
            case "view":
                viewTicket(req, resp);
                break;
            case "download":
                downloadAttachment(req, resp);
                break;
            case "list":
            default:
                listTickets(resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "create":
                createTicket(req, resp);
                break;
            case "list":
            default:
                resp.sendRedirect("tickets");
                break;
        }
    }

    /**
     * Displays form for entering ticket info. The form sends POST to the same servlet.
     * @param resp response used for appending content
     * @throws IOException if an output exception occurred when writing page header
     */
    private void showTicketForm(HttpServletResponse resp) throws IOException {
        PrintWriter writer = writeHeader(resp);

        writer.append("<h2>Create a Ticket</h2>\r\n");
        writer.append("<form method=\"POST\" action=\"tickets\" enctype=\"multipart/form-data\">\r\n");
        writer.append("    <input type=\"hidden\" name=\"action\" value=\"create\"/>\r\n");
        writer.append("    Your Name<br/>\r\n");
        writer.append("    <input type=\"text\" name=\"customerName\"/><br/><br/>\r\n");
        writer.append("    Subject<br/>\r\n");
        writer.append("    <input type=\"text\" name=\"subject\"/><br/><br/>\r\n");
        writer.append("    Body<br/>\r\n");
        writer.append("    <textarea name=\"body\" rows=\"5\" cols=\"30\"></textarea><br/><br/>\r\n");
        writer.append("    <b>Attachments</b><br/>\r\n");
        writer.append("    <input type=\"file\" name=\"file1\"/><br/><br/>\r\n"); // todo: how can I attach more than 1 file
        writer.append("    <input type=\"submit\" value=\"Submit\"/>\r\n");
        writer.append("</form>\r\n");

        writeFooter(writer);
    }

    /**
     * Creates ticket using info from POST request and adds the ticket to the database.
     * @param req request used for getting parameters
     * @param resp response used for redirecting to view page of the added ticket
     */
    private void createTicket(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(req.getParameter("customerName"));
        ticket.setSubject(req.getParameter("subject"));
        ticket.setBody(req.getParameter("body"));

        Part filePart = req.getPart("file1");
        if (filePart != null) {
            Attachment attachment = processAttachment(filePart);
            if (attachment != null) {
                ticket.addAttachemn(attachment);
            }
        }

        int id;
        synchronized (this) {
            id = TICKET_ID_SEQUENCE++;
            ticketDatabase.put(id, ticket);
        }

        resp.sendRedirect("tickets?action=view&ticketId=" + id);
    }

    /**
     * Converts the specified <code>Part</code> object to <code>Attachment</code> object.
     * @param filePart part of multipart request which represents the attachment file
     * @return attachment object containing bytes of attached file
     * @throws IOException if an input exception occurs when getting bytes from file part
     */
    private Attachment processAttachment(Part filePart) throws IOException {
        InputStream stream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int numberOfBytes;
        final byte[] byteArray = new byte[1024];
        while((numberOfBytes = stream.read(byteArray)) != -1) {
            outputStream.write(byteArray, 0, numberOfBytes);
        }

        Attachment attachment = new Attachment();
        attachment.setName(filePart.getSubmittedFileName());
        attachment.setContents(outputStream.toByteArray());

        return attachment;
    }

    private void viewTicket(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("ticketId");
        Ticket ticket = getTicket(idString, resp);
        if (ticket == null) {
            return;
        }

        PrintWriter writer = writeHeader(resp);

        writer.append("<h2>Ticket #").append(idString)
                .append(": ").append(ticket.getSubject()).append("</h2>\r\n")
                .append("<i>Customer Name - ").append(ticket.getCustomerName())
                .append("</i><br/><br/>\r\n")
                .append(ticket.getBody()).append("<br/><br/>\r\n");

        if (ticket.getNumberOfAttachments() > 0) {
            writer.append("Attachments: ");
            int i = 0;
            for (Attachment attachment : ticket.getAttachments()) {
                if (i++ > 0) {
                    writer.append(", ");
                }
                writer.append("<a href=\"tickets?action=download&ticketId=")
                        .append(idString).append("&attachment=")
                        .append(attachment.getName()).append("\">")
                        .append(attachment.getName()).append("</a>");
            }
            writer.append("<br/><br/>\r\n");
        }

        writer.append("<a href=\"tickets\">Return to list tickets</a>\r\n");

        writeFooter(writer);
    }

    private void downloadAttachment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("ticketId");
        Ticket ticket = getTicket(idString, resp);
        if (ticket == null) {
            return;
        }

        String redirectLocation = "ticket?action=view&ticketId=" + idString;
        String name = req.getParameter("attachment");
        if (name == null) {
            resp.sendRedirect(redirectLocation);
            return;
        }

        Attachment attachment = ticket.getAttachment(name);
        if (attachment == null) {
            resp.sendRedirect(redirectLocation);
            return;
        }

        // The Content-Disposition header forces the browser to ask the client to save or download the file
        // instead of just opening the file inline in the browser.
        resp.setHeader("Content-Disposition", "attachment; filename=" + attachment.getName());
        // The binary content type keeps the data from having some kind of character encoding applied to it.
        resp.setContentType("application/octet-stream");

        ServletOutputStream stream = resp.getOutputStream();
        stream.write(attachment.getContents());
    }

    /**
     * Gets ticket from database by specified id string.
     * @param idString id string
     * @param resp response used for redirect if id not present, ticket not found or exception thrown
     * @return ticket object from the database
     */
    private Ticket getTicket(String idString, HttpServletResponse resp) throws IOException {
        if (idString == null || idString.isEmpty()) {
            resp.sendRedirect("tickets");
            return null;
        }

        try {
            Ticket ticket = ticketDatabase.get(Integer.parseInt(idString));
            if (ticket == null) {
                resp.sendRedirect("tickets");
                return null;
            }
            return ticket;
        } catch(Exception e) {
            resp.sendRedirect("tickets");
            return null;
        }
    }

    /**
     * Displays list of tickets, if database contains any tickets.
     * @param resp response used for appending content
     */
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
                        .append(" (customer: ").append(ticket.getCustomerName()).append(")<br/>\r\n");
            }
        }

        writeFooter(writer);
    }

    /**
     * Writes header for every html page.
     * @param resp response object used for writing
     * @return PrintWriter which may be used for subsequent writing
     */
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
