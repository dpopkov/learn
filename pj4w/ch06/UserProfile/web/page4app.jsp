<html>
<head>
    <title>Get attribute from ServletContext</title>
</head>
<body>

<h2>Get attribute from ServletContext</h2>

<h3>This variable will be available in other session only is the attributes is set for ServletContext</h3>

User ID: ${user.userId}<br/>
Username: ${user.username} (${user.username.length()} characters)<br/>
Full Name: ${fn:escapeXml(user.lastName) += ', ' += fn:escapeXml(user.firstName)}<br/><br/>

<b>Permissions (${fn:length(user.permissions)})</b><br/>
User: ${user.permissions["user"]}<br/>
Moderator: ${user.permissions["moderator"]}<br/>
Administrator: ${user.permissions["admin"]}<br/>
</body>
</html>
