<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SIGN UP</title>
</head>
<body>
<div id="header" style="height: 72px; background-color: black">
    <table>
        <tr>
            <td>
                <img src="http://i.piccy.info/i9/899fac894a27492e489a38308c7a7333/1528739663/4352/1226734/logo_240.jpg"/>
            </td>
            <td>
                <form action="/login" method="get">
                    <input type="submit" value="Sign In"/>
                </form>
            </td>
            <td>
                <form action="/register" method="get">
                    <input type="submit" value="Sign Up"/>
                </form>
            </td>
        </tr>
    </table>
</div>
<div>
    <form action="/register" method="post">
        Enter login: <input name="login"/><br/>
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