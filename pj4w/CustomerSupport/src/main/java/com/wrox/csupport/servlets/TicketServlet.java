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
        if (req.getSession().getAttribute("username") == null) {
            resp.sendRedirect("login");
            return;
        }

        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "create":
                showTicketForm(req, resp);
                break;
            case "view":
                viewTicket(req, resp);
                break;
            case "download":
                downloadAttachment(req, resp);
                break;
            case "list":
            default:
                listTickets(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") == null) {
            resp.sendRedirect("login");
            return;
        }

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
     * Forwards to form for entering ticket info. The form sends POST to the same servlet.
     * @param resp response used for appending content
     * @throws IOException if an output exception occurred when writing page header
     */
    private void showTicketForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/jsp/view/ticketForm.jsp")
                .forward(req, resp);
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
                ticket.addAttachment(attachment);
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

    private void viewTicket(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String idString = req.getParameter("ticketId");
        Ticket ticket = getTicket(idString, resp);
        if (ticket == null) {
            return;
        }

        req.setAttribute("ticketId", idString);
        req.setAttribute("ticket", ticket);

        req.getRequestDispatcher("/WEB-INF/jsp/view/viewTicket.jsp")
                .forward(req, resp);
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
     * Forwards to list of tickets, if database contains any tickets.
     * @param resp response used for appending content
     */
    private void listTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("ticketDatabase", ticketDatabase);
        req.getRequestDispatcher("/WEB-INF/jsp/view/listTickets.jsp")
                .forward(req, resp);
    }
}
