<%@ page import="java.util.List" %>
<%!
    private static String toString(long timeInterval) {
        if (timeInterval < 1_000) {
            return "less than one second";
        } else if (timeInterval < 60_000) {
            return (timeInterval / 1_000) + " seconds";
        } else {
            return "about " + (timeInterval / 60_000) + " minutes";
        }
    }
%>
<%
    int numberOfSessions = (Integer) request.getAttribute("numberOfSessions");
    List<HttpSession> sessions = (List<HttpSession>) request.getAttribute("sessionList");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>

</head>
<body>

<p><%@include file="/WEB-INF/jsp/logoutLink.jsp" %></p>

<h2>Sessions</h2>

<p>There are a total of <%= numberOfSessions %> active sessions in this application.</p>
<ul>
<%
    long timestamp = System.currentTimeMillis();
    for (HttpSession aSession : sessions) {
        out.print("<li>" + aSession.getId() + " - " + aSession.getAttribute("username"));
        if(aSession.getId().equals(session.getId())) {
            out.print(" (you)");
        }
        out.print(" - last active " + toString(timestamp - aSession.getLastAccessedTime()));
        out.println(" ago</li>");
    }
%>
</ul>
</body>
</html>
