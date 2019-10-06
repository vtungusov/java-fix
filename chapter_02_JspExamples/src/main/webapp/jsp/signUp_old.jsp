<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.vtungusov.models.User" %><%--
  Created by IntelliJ IDEA.
  User: BigBoss
  Date: 04-Oct-19
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<User> users = (ArrayList) request.getAttribute("usersFromServer");
%>
<table>
    <tr>
        <th>user name</th>
        <th>birth date</th>
    </tr>
    <% for (User user : users) {
    %>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getBirthDate()%>
        </td>
    </tr>
    <%
    } %>
</table>

</body>
</html>
