<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SIGN IN</title>

</head>
<body>
<jsp:directive.include file="header.jspf"/>
<div>
    <form action="/login" method="post">
        Enter login: <input name="login"/><br/>
        Enter pass: <input type="password" name="pass"/><br/>
        <input type="submit" value="Sign In"/>
    </form>
</div>
</body>
</html>
