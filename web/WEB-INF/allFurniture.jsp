<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL FURNITURE</title>
</head>
<body>

<h1>WELCOME ALL FURNITURE PAGE</h1>

<%
    List<Item> furniture = (List<Item>) request.getAttribute("allFurniture");
%>

<%for (Item furniture1 : furniture) {%>
<div style="padding-left: 40px">
    <div style="width: 250px; height: 350px;float: left;padding-right: 20px">
        <img src="/image?path=<%=furniture1.getPicUrl()%>" width="200px" height="300px"><br>
        <h3><%=furniture1.getTitle()%></h3>
        <h3><%=furniture1.getPrice()%> $</h3>
    </div>
</div>
<%}%>

</body>
</html>
