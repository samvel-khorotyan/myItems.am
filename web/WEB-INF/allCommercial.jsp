<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL COMMERCIAL</title>
</head>
<body>

<h1>WELCOME ALL COMMERCIAL PAGE</h1>

<%
    List<Item> commercial = (List<Item>) request.getAttribute("allCommercial");
%>

<%for (Item commercial1 : commercial) {%>
<div style="padding-left: 40px">
    <div style="width: 250px; height: 350px;float: left;padding-right: 20px">
        <img src="/image?path=<%=commercial1.getPicUrl()%>" width="200px" height="300px"><br>
        <h3><%=commercial1.getTitle()%></h3>
        <h3><%=commercial1.getPrice()%> $</h3>
    </div>
</div>
<%}%>

</body>
</html>
