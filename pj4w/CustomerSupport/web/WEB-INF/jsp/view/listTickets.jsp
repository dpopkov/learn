<%--@elvariable id="ticketDatabase" type="java.util.Map<Integer,com.wrox.csupport.model.Ticket>"--%>
<template:basic htmlTitle="Tickets" bodyTitle="Tickets">

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
                <c:out value="${wrox:abbreviate(entry.value.subject, 60)}" />
            </a><br/>
            <c:out value="${entry.value.customerName}" /> created ticket
            <wrox:formatDate value="${entry.value.dateCreated}" type="both"
                             timeStyle="short" dateStyle="medium" /><br/>
        </c:forEach>
    </c:otherwise>
</c:choose>

</template:basic>