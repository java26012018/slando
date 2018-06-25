<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SIGN IN</title>
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
    <form action="/login" method="post">
        Enter login: <input name="login"/><br/>
        Enter pass: <input type="password" name="pass"/><br/>
        <input type="submit" value="Sign In"/>
    </form>
</div>
</body>
</html>
