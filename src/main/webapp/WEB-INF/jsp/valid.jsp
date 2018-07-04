<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 04.07.2018
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invalid data</title>
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
<div id ="validAnsver">
    <h2 style="align-content: center">
        ${validUser}
    </h2>
</div>
</body>
</html>
