<%--@elvariable id="timestamp" type="long"--%>
<%--@elvariable id="numberOfSessions" type="java.lang.Integer"--%>
<%--@elvariable id="sessionList" type="java.util.List<javax.servlet.http.HttpSession"--%>
<template:basic htmlTitle="Active Sessions" bodyTitle="Active Sessions">

<p>There are a total of ${numberOfSessions} active sessions in this application.</p>
<ul>
    <c:forEach items="${sessionList}" var="s">
        <li>
            <c:out value="${s.id} - ${s.getAttribute('username')}" />
            <c:if test="${s.id == pageContext.session.id}">&nbsp;(you)</c:if>
            &nbsp;- last active
            ${wrox:timeIntervalToString(timestamp - s.lastAccessedTime)} ago
        </li>
    </c:forEach>
</ul>

</template:basic>
