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
    <form method="post" action="<c:url value="/login"/>">
        <label class="input-field" for="name">User name
            <input type="text" id="name" name="name" required>
        </label>
        <label class="input-field" for="password">Password
            <input type="password" id="password" name="password" required>
        </label>
        <input type="submit" value="Sing Up">
    </form>
</div>
<div class="form-style-2">
</div>
</body>
</html>
