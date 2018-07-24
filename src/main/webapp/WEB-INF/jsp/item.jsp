<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>SLANDO - OLX</title>

</head>
<body>
<jsp:directive.include file="header.jspf"/>
<div id="content" style="background-color: aquamarine">
    <div style="width: 1000px; height: 600px; display: flex; justify-content: left">
        <table>
            <tr>
                <td>
                    <h2>${item.name}</h2>
                </td>
            </tr>
            <tr>

                <td>
                    <img src="${item.pic}" style="height: 500px"/>
                </td>
                <td>
                    <h4>${item.about}</h4>
                </td>
            </tr>
            <tr>
                <td>
                    <h1>${item.price} UAH</h1>
                </td>
                <td>

                </td>
                <td>
                    <h4>${item.city}</h4>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
