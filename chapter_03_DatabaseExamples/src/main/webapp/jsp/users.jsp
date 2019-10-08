<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">Enter user name for search:</div>
    <form method="get" action="${pageContext.request.contextPath}/users">
        <label class="input-field" for="first-name">First name
            <input type="text" id="first-name" name="firstName">
        </label>
        <input type="submit" value="Search by name">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2">
        <div class="form-style-2-heading">Already registered:</div>
        <table>
            <tr>
                <th>First name</th>
            </tr>
            <c:forEach items="${usersFromServer}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
