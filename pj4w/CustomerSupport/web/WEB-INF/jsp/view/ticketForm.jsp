<template:basic htmlTitle="Create a Ticket" bodyTitle="Create a Ticket">
    <jsp:attribute name="extraNavigaitionContent">
        <a href="<c:url value="/sessions"/>">Session one more time</a><br/>
    </jsp:attribute>
    <jsp:body>
    <form method="post" action="tickets" enctype="multipart/form-data">
        <input type="hidden" name="action" value="create"/>
        <input type="text" name="subject" placeholder="Subject"><br/><br/>
        <textarea name="body" rows="5" cols="30" placeholder="Body"></textarea><br/><br/>
        <b>Attachment(s)</b><br/>
        <input type="file" name="file1"/><br/><br/>
        <input type="submit" value="Submit"/>
    </form>
    </jsp:body>
</template:basic>
