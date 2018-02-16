<%@ page import="com.wrox.csupport.model.Ticket " %>
<%@ page import="com.wrox.csupport.model.Attachment " %>
<%
    String ticketId = (String) request.getAttribute("ticketId");
    Ticket ticket = (Ticket) request.getAttribute("ticket");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<p><%@include file="/WEB-INF/jsp/logoutLink.jsp" %></p>
<h2>Ticket #<%= ticketId %>: <%= ticket.getSubject()%></h2>
<i>Customer Name - <%= ticket.getCustomerName()%></i><br/><br/>
<%= ticket.getBody() %><br/><br/>
<%
    if (ticket.getNumberOfAttachments() > 0) {
        %>Attachment(s): <%
        int i = 0;
        for (Attachment a : ticket.getAttachments() ) {
            if (i++ > 0) {
                out.print(", ");
            }
            %><a href="<c:url value="/tickets">
                <c:param name="action" value="download" />
                <c:param name="ticketId" value="<%=ticketId%>" />
                <c:param name="attachment" value="<%=a.getName()%>" />
            </c:url>"><%= a.getName()%></a><%
        }
    }
%>
<p><a href="<c:url value="/tickets" />">Return to list tickets</a></p>
</body>
</html>
