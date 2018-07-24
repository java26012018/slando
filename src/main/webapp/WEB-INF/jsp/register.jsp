<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SIGN UP</title>
</head>
<body>
<jsp:directive.include file="header.jspf"/>
<div>
    <form action="/register" method="post">
        Enter login: <input name="login"/><br/>e
        Enter pass: <input type="password" name="pass1"/><br/>
        Enter again: <input type="password" name="pass2"/><br/>
        Enter phone: <input name="phone"/><br/>
        Enter email: <input name="email"/><br/>
        Enter city: <input name="city"/><br/>
        <input type="submit" value="Sign Up"/>
    </form>
</div>
</body>
</html>