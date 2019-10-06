<%--
  Created by IntelliJ IDEA.
  User: BigBoss
  Date: 05-Oct-19
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1><span style="color: ${cookie.color.value}">Hello</span></h1>
<form method="post" action="${pageContext.request.contextPath}/home">
    <select name="color" id="color">
        <option value="red">Красный</option>
        <option value="black">Черный</option>
        <option value="white">Белый</option>
    </select>
    <input type="submit" value="Изменить цвет">
</form>
</body>
</html>
