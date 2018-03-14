package com.wrox.pj4w.ch10.servlets;

import com.wrox.pj4w.ch10.messages.ClusterMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class ClusterNodeServlet extends HttpServlet {
    private Session session;
    private String nodeId;

    @Override
    public void init() throws ServletException {
        nodeId = getInitParameter("nodeId");
        String path = getServletContext().getContextPath() + "/clusterNodeSocket/" + nodeId;

        try {
            URI uri = new URI("ws", "localhost:8080", path, null, null);
            session = ContainerProvider.getWebSocketContainer().connectToServer(this, uri);
        } catch (URISyntaxException | IOException | DeploymentException e) {
            throw new ServletException("Cannot connect to " + path, e);
        }
    }

    @Override
    public void destroy() {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClusterMessage message = new ClusterMessage(nodeId,
                "request:{ip:\"" + req.getRemoteAddr() + "\",queryString:\"" + req.getQueryString() + "\"}");
        try(OutputStream output = session.getBasicRemote().getSendStream();
                ObjectOutputStream stream = new ObjectOutputStream(output)) {
            stream.writeObject(message);
        }
        resp.getWriter().append("OK");
    }

    @OnMessage
    public void onMessage(InputStream input) {
        try (ObjectInputStream stream = new ObjectInputStream(input)) {
            ClusterMessage message = (ClusterMessage) stream.readObject();
            System.out.println("INFO (Node " + nodeId
                    + "): Message received from cluster; node = " + message.getNodeId()
                    + ", message = " + message.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(CloseReason reason) {
        CloseReason.CloseCode code = reason.getCloseCode();
        if (code != CloseReason.CloseCodes.NORMAL_CLOSURE) {
            System.err.println("ERROR: WebSocket connection closed unexpectedly;"
                    + " code = " + code + ", reason = " + reason.getReasonPhrase());
        }
    }
}
