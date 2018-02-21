<%--@elvariable id="ticketDatabase" type="java.util.Map<Integer,com.wrox.csupport.model.Ticket>"--%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>

<p><%@include file="/WEB-INF/jsp/logoutLink.jsp" %></p>

<h2>Tickets</h2>

<p><a href="tickets?action=create">Create Tickets</a></p>

<c:choose>
    <c:when test="${ticketDatabase.size() == 0}">
        <p><i>There are no tickets in the system.</i></p>
    </c:when>
    <c:otherwise>
        <c:forEach items="${ticketDatabase}" var="entry">
            Ticket ${entry.key}:
            <a href="<c:url value="/tickets">
                        <c:param name="action" value="view" />
                        <c:param name="ticketId" value="${entry.key}" />
                    </c:url>">
                <c:out value="${entry.value.subject}" />
            </a>
            (customer: <c:out value="${entry.value.customerName}" />)
            <br/>
        </c:forEach>
    </c:otherwise>
</c:choose>

</body>
</html>
