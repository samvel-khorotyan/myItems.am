<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL HOUSES</title>
</head>
<body>

<h1>WELCOME ALL HOUSES</h1>

<%
    List<Item> houses = (List<Item>) request.getAttribute("houses");
%>

<%for (Item house : houses) {%>
<div style="padding-left: 40px">
    <div style="width: 250px; height: 350px;float: left;padding-right: 20px">
        <img src="/image?path=<%=house.getPicUrl()%>" width="200px" height="300px"><br>
        <h3><%=house.getTitle()%></h3>
        <h3><%=house.getPrice()%> $</h3>
    </div>
</div>
<%}%>
</body>
</html>
