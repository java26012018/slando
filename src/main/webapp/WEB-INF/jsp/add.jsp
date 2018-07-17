<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<style>
    body{
        margin: 0;
        padding: 0;
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

<form method="post">
    <div class="container">
        <div class="col1">
            <p>Category:</p>
            <p>Name:</p>
            <p>About:</p>
            <p>Picture(url):</p>
            <p>Price:</p>
        </div>
        <div class="col2 col1">
            <input name="cat">
            <input name="name">
            <input name="about">
            <input name="pic">
            <input name="price">
        </div>
    </div>
    <div style="display: flex; justify-content: center">
    <input type="submit" value="Add item">
    </div>
</form>

</body>
</html>
