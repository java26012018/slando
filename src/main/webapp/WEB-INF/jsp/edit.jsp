<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 24.07.2018
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<jsp:directive.include file="header.jspf"/>
<div id="content" style="background-color: aquamarine">
    <div style="width: 1000px; height: 600px; display: flex; justify-content: left">
        <form action="/edit" method="post">
            <table>
                <tr>
                    <td>
                        <input type="text" value="${item.name}" name="iname"/> Enter name
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="${item.pic}" name="ipic"/> enter URL pic
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="${item.about}" name="iabout"/>enter about
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="${item.price}" name="iprice"/> enter price in UAH
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="${item.city}" name="icity"/> enter city
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="${item.email}" name="imail"/> enter email
                    </td>
                </tr>
            </table>
            <input type="submit" value="Accept change">
        </form>
    </div>
</div>
</body>
</html>
