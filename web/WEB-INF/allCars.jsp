<%@ page import="java.util.List" %>
<%@ page import="model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL CARS</title>
</head>
<body>

<h1>WELCOME ALL CARS PAGE</h1>

<%
    List<Item> cars = (List<Item>) request.getAttribute("cars");
%>

<%for (Item car : cars) {%>
<div style="padding-left: 40px">
    <div style="width: 250px; height: 350px;float: left;padding-right: 20px">
        <img src="/image?path=<%=car.getPicUrl()%>" width="200px" height="300px"><br>
        <h3><%=car.getTitle()%></h3>
        <h3><%=car.getPrice()%> $</h3>
    </div>
</div>
<%}%>

</body>
</html>
