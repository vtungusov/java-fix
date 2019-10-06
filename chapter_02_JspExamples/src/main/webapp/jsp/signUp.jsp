<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">Please sign Up!</div>
    <form method="post" action="<c:url value="/signUp"/>">
        <label class="input-field" for="name">User name
            <input type="text" id="name" name="name" required>
        </label>
        <label class="input-field" for="birthDate">Birth Date
            <input type="text" id="birthDate" name="birthDate" required>
        </label>
        <label class="input-field" for="password">Password
            <input type="password" id="password" name="password" required>
        </label>
        <input type="submit" value="Sing Up">
    </form>
</div>
<div class="form-style-2">
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.birthDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
