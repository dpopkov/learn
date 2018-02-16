<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.wrox.pj4w.ch05.model.PageVisit" %>
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
    SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Session Activity Tracker</title>
</head>
<body>

<h2>Session Activity Tracker</h2>

<h3>Session Properties</h3>

Session ID: <%= session.getId() %><br/>
Session is new: <%= session.isNew() %><br/>
Session created: <%= dateFormatter.format(new Date(session.getCreationTime()))%><br/>

<h3>Page Activity This Session</h3>

<%
    @SuppressWarnings("unchecked")
    Vector<PageVisit> visits = (Vector<PageVisit>) session.getAttribute("visits");

    for (PageVisit visit : visits) {
        out.print(visit.getRequest());
        if (visit.getIpAddress() != null) {
            out.print(" from IP " + visit.getIpAddress().getHostAddress());
        }
        out.print(" (" + dateFormatter.format(new Date(visit.getEnteredTimestamp())));
        if (visit.getLeftTimestamp() != null) {
            out.print(", stayed for " + toString(visit.getLeftTimestamp() - visit.getEnteredTimestamp()));
        }
        out.print(")<br/>");
    }
%>
</body>
</html>
