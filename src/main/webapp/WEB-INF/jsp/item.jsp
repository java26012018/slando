<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>SLANDO - OLX</title>
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
            <c:if test="${not empty user}">
                <td>
                    <a href="/?exit=true">
                        <input type="submit" value="Exit"/>
                    </a>
                </td>
            </c:if>
        </tr>
    </table>
</div>
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
