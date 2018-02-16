<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<h2>Create a Ticket</h2>
<form method="post" action="tickets" enctype="multipart/form-data">
    <input type="hidden" name="action" value="create"/>
    <input type="text" name="customerName" placeholder="Your Name"><br/><br/>
    <input type="text" name="subject" placeholder="Subject"><br/><br/>
    <textarea name="body" rows="5" cols="30" placeholder="Body"></textarea><br/><br/>
    <b>Attachment(s)</b><br/>
    <input type="file" name="file1"/><br/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
