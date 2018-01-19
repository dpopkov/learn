<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkboxes</title>
</head>
<body>
<%@include file="header.jsp" %>
<%
    String[] fruits = request.getParameterValues("fruit");
%>
<form action="checkboxes.jsp" method="post">
    <%
        if (fruits != null && fruits.length > 0) {
    %><h2>Your Selection:</h2>
    <ul><%
        for (String fruit : fruits) {
            out.println("<li>" + fruit + "</li>");
        }
    %></ul>
    <%
    } else {
    %>You did not select any fruits.<br/><br/><%
    }
%>
    <h2>Select the fruits you like to eat:</h2>
    <label>
        <input type="checkbox" name="fruit" value="Banana"/>
        Banana
    </label><br/>
    <label>
        <input type="checkbox" name="fruit" value="Apple"/>
        Apple
    </label><br/>
    <label>
        <input type="checkbox" name="fruit" value="Orange"/>
        Orange
    </label><br/>
    <label>
        <input type="checkbox" name="fruit" value="Guava"/>
        Guava
    </label><br/>
    <label>
        <input type="checkbox" name="fruit" value="Kiwi"/>
        Kiwi
    </label><br/>
    <input type="submit" value="Submit">
</form>
</body>
</html>
