<html>
<head>
    <title>Get attribute from Session</title>
</head>
<body>

<h2>Get attribute from Session</h2>

<h3>This variable will be available only if attribute is set for session</h3>

User ID: ${user.userId}<br/>
Username: ${user.username} (${user.username.length()} characters)<br/>
Full Name: ${fn:escapeXml(user.lastName) += ', ' += fn:escapeXml(user.firstName)}<br/><br/>

<b>Permissions (${fn:length(user.permissions)})</b><br/>
User: ${user.permissions["user"]}<br/>
Moderator: ${user.permissions["moderator"]}<br/>
Administrator: ${user.permissions["admin"]}<br/>
</body>
</html>
