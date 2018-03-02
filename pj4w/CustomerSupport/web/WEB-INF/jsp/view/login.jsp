<%--@elvariable id="loginFailed type="java.lang.Boolean"--%>
<template:loggedOut htmlTitle="Log In" bodyTitle="Log In">

<p>You must log in to access the customer support site.</p>

<c:if test="${loginFailed}">
    <p><b>The username or password you entered are not correct.
            Please try again.
    </b></p>
</c:if>

<form method="post" action="<c:url value="/login"/>">
    Username:<br/>
    <input type="text" name="username" /><br/><br/>
    Password:<br/>
    <input type="password" name="password" /><br/><br/>
    <input type="submit" value="Log In" />
</form>
</template:loggedOut>
