<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Context Parameters</title>
</head>
<body>
<%@include file="header.jsp"%>
<h2>Application init parameters</h2>
<p>Book name: <%=application.getInitParameter("book-name")%></p>
<p>Chapter name: <%=application.getInitParameter("chapter-name")%></p>
</body>
</html>
