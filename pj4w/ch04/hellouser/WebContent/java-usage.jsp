<%@ page contentType="text/html;charset=UTF-8" %>
<%!
    private final int five = 0;
    protected String cowboy = "rodeo";

    public long addFive(long number) {
        return number + 5L;
    }

    public class MyInnerClass {
        @Override
        public String toString() {
            return "MyInnerClass which does nothing";
        }
    }

    private MyInnerClass instanceVariable = new MyInnerClass();
%>
<%
    class WeirdClassWithinMethod {
        @Override
        public String toString() {
            return "WeirdClassWithinMethod which does nothing";
        }
    }
    WeirdClassWithinMethod weirdClass = new WeirdClassWithinMethod();
    MyInnerClass innerClass = new MyInnerClass();
    int seven;
    seven = 7;
%>
<html>
<head>
    <title>Java usage in JSP pages</title>
</head>
<body>
<h2>Java usage in JSP pages</h2>
<p><%=addFive(seven)%>
</p>
<p>instanceVariable: <%=instanceVariable.toString()%></p>
<p>innerClass: <%=innerClass.toString()%></p>
<p>weirdClass: <%=weirdClass.toString()%></p>
</body>
</html>
