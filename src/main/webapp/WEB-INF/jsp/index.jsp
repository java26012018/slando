<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>SLANDO - OLX</title>
</head>
<body>
<jsp:directive.include file="header.jspf"/>
<div id="content" style="background-color: aquamarine">
    <c:forEach items="${items}" var="item">
        <div style="width: 1000px; height: 250px; display: flex; justify-content: left">
            <table>
                <tr>
                    <td>
                        <a href="/item?id=${item.id}">
                            <img src="${item.pic}" style="height: 200px"/>
                        </a>
                    </td>
                    <td>
                        <h4>${item.about}</h4>
                    </td>
                    <td>
                        <h2>${item.owner}</h2>
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
                    <c:if test="${user.login == item.owner}">
                        <td>
                            <a href="/edit?id=${item.id}">
                                <input type="submit" value="Edit Item"/>
                            </a>
                        </td>
                    </c:if>
                </tr>
            </table>
        </div>
        <hr/>
    </c:forEach>
</div>
</body>
</html>
