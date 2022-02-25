<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MY ANNOUNCEMENTS</title>
</head>
<body>

<h1>WELCOME MY ANNOUNCEMENTS</h1>

<%
    List<Item> myItems = (List<Item>) request.getAttribute("myItems");
%>

<%for (Item myItem : myItems) {%>
<div style="padding-left: 40px">
    <div style="width: 250px; height: 350px;float: left;padding-right: 20px">
        <img src="/image?path=<%=myItem.getPicUrl()%>" width="200px" height="300px"><br>
        <h3><%=myItem.getTitle()%></h3>
        <h3><%=myItem.getPrice()%> $</h3>
    </div>
</div>
<%}%>

</body>
</html>
