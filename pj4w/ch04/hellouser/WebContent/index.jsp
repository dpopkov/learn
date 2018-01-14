<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Hello World Application</title>
</head>
<body>
<%
    String fooStr = new Date().toString();
%>
    Hello, World!
<p><em><%=fooStr%></em></p>

<p>Try to go to <a href="blank.jsp">blank page</a> (now contains html, but without proper charset)</p>
<p>This text is in Russian language: Здравствуй, Мир</p>

<p>Try to go to <a href="java-usage.jsp">java-usage page</a></p>
</body>
</html>
