<%
    application.setAttribute("appAttribute", "foo");
    pageContext.setAttribute("pageAttribute", "bar42");
    session.setAttribute("sessionAttribute", "sand");
    request.setAttribute("requestAttribute", "castle");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Information</title>
</head>
<body>

<h3>pageContext</h3>
Remote Address: ${pageContext.request.remoteAddr}<br/>
Request URL: ${pageContext.request.requestURL}<br/>
Request URI: ${pageContext.request.requestURI}<br/>
Query String: ${pageContext.request.queryString}<br/>
Character Encoding: ${pageContext.request.characterEncoding}<br/>
Content Length: ${pageContext.request.contentLength}<br/>
Session ID: ${pageContext.request.session.id}<br/>

<h3>Scopes</h3>
Application Scope: ${applicationScope["appAttribute"]}<br/>
Page Scope: ${pageScope["pageAttribute"]}<br/>
Session Scope: ${sessionScope["sessionAttribute"]}<br/>
Request Scope: ${requestScope["requestAttribute"]}<br/>

<h3>Parameters</h3>
User Parameter: ${param["user"]}<br/>
Color Multi-Param: ${fn:join(paramValues["colors"], ", ")}<br/>

<h3>Headers</h3>
Accept Header: ${header["Accept"]}<br/>
Accept-Language Header: ${header["Accept-Language"]}<br/>
Cookie Header: ${header["Cookie"]}<br/>
Host Header: ${header["Host"]}<br/>
User-Agent Header: ${header["User-Agent"]}<br/>

<h3>Session ID</h3>
Session ID Cookie Value: ${cookie["JSESSIONID"].value}<br/>

</body>
</html>
