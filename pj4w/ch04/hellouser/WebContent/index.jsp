<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Hello World Application</title>
</head>
<body>
<%
    // Java comment: the line below contains declaration of a local variable.
    String dateStr = new Date().toString();
%>
    Hello, World!
<p><em><%=dateStr%></em></p>

<p>Try to go to <a href="blank.jsp">blank page</a> (now contains html, but without proper charset)</p>
<!-- This is HTML/XML comment: it appears in the source of the response; browser ignores it. -->
<!-- This is HTML/XML comment: any JSP tags will be evaluated - <%=dateStr%> -->
<p>This text is in Russian language: Здравствуй, Мир</p>

<p>Try to go to <a href="java-usage.jsp">java-usage page</a></p>
<p>Next paragraph is JSP commented</p>

<%-- JSP comment
<p>Try to go to <a href="java-usage.jsp">java-usage page</a></p>--%>

</body>
</html>
