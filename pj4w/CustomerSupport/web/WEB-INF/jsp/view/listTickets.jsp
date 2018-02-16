<%@ page import="java.util.Map" %>
<%@ page import="com.wrox.csupport.model.Ticket" %>
<%
    @SuppressWarnings("unchecked")
    Map<Integer, Ticket> ticketDatabase =
            (Map<Integer, Ticket>) request.getAttribute("ticketDatabase");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>

<p><%@include file="/WEB-INF/jsp/logoutLink.jsp" %></p>

<h2>Tickets</h2>

<p><a href="tickets?action=create">Create Tickets</a></p>
<%
    if (ticketDatabase.size() == 0) {
%><p><i>There are no tickets in the system.</i></p><%
} else {
    for (int id : ticketDatabase.keySet()) {
        String idString = Integer.toString(id);
        Ticket ticket = ticketDatabase.get(id);
        %>Ticket #<%= idString %>:
        <a href="<c:url value="/tickets">
            <c:param name="action" value="view" />
            <c:param name="ticketId" value="<%= idString %>" />
        </c:url>"><%= ticket.getSubject() %>
        </a>
        (customer: <%= ticket.getCustomerName() %>)<br/><%
    }
}
%>

</body>
</html>
