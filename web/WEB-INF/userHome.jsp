<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER HOME</title>
</head>
<body>

<%User user = (User) request.getSession().getAttribute("user");%>

<h1>WELCOME USER HOME PAGE</h1>

<h3>WELCOME <%=user.getName() + " " + user.getSurname()%>
</h3>

<a href="/addAnnouncementMediator"><h3>ADD ANNOUNCEMENT</h3></a>

<a href="/myAnnouncements"><h3>MY ANNOUNCEMENTS</h3></a>

<a href="/logout"><h3>LOGOUT</h3></a>

</body>
</html>
