<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit profile</title>
</head>
<body>

<style>
    body{
        margin: 0;
        padding: 0;
    }
    input{
        margin-top: 2px;
    }
    .container{
        margin-top: 30vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    p{
        margin: 3px 0 0 0;
        padding: 0;
        font-size: 20px;
    }
    .col1{
        display: flex;
        flex-direction: column;
    }
    .col2{
        margin-left: 50px;
        margin-top: 5px;
    }
</style>

<table style="background: black; width: 100%">
    <tr>
        <td>
            <img src="http://i.piccy.info/i9/899fac894a27492e489a38308c7a7333/1528739663/4352/1226734/logo_240.jpg"/>
        </td>
    </tr>
</table>
<h2 style="text-align: center">Input just the fields you want to change in your profile</h2>
<form method="post">
    <div class="container">
        <div class="col1">
            <p>Old password(obligatory):</p>
            <p>New password:</p>
            <p>New phone:</p>
            <p>City:</p>
            <p>Email:</p>
        </div>
        <div class="col2 col1">
            <input name="pass1">
            <input name="pass2">
            <input name="phone">
            <input name="city">
            <input name="email">
        </div>
    </div>
    <div style="display: flex; justify-content: center">
        <input type="submit" value="Change">
    </div>
</form>

</body>
</html>
