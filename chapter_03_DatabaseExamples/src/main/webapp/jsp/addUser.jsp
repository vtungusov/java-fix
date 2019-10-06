<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">Please add user!</div>
    <form method="post" action="${pageContext.request.contextPath}/users">
        <label class="input-field" for="first-name">First name
            <input type="text" id="first-name" name="first-name" required>
        </label>
        <label class="input-field" for="last-name">Last Name
            <input type="text" id="last-name" name="last-name" required>
        </label>
        <input type="submit" value="Sing Up">
    </form>
</div>
<div class="form-style-2">
</div>
</body>
</html>
