<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>home</title>
  </head>
  <body>

  <h1>WELCOME HOME PAGE</h1>

  <a href="/loginMediator">LOGIN</a><br>
  <a href="/registerMediator">REGISTER</a><br>

    <div >
      <h3 style="float: left;padding-right: 10px"><a href="/?general=<%="general"%>">general |</a></h3>
      <h3 style="float: left;padding-right: 10px"><a href="/itemDetail?cars=<%="cars"%>">cars |</a></h3>
      <h3 style="float: left;padding-right: 10px"><a href="/itemDetail?houses=<%="houses"%>">houses |</a></h3>
      <h3 style="float: left;padding-right: 10px"><a href="/itemDetail?Commercial=<%="Commercial"%>">Commercial |</a></h3>
      <h3 style="float: left;padding-right: 10px"><a href="/itemDetail?furniture=<%="furniture"%>">furniture</a></h3>
    </div>

  <%
    List<Item> allItems = (List<Item>) request.getAttribute("item");
  %>

  <%for (Item item : allItems) {%>
  <div style="padding-left: 40px">
    <div style="width: 250px; height: 350px;float: left;padding-right: 20px">
      <img src="/image?path=<%=item.getPicUrl()%>" width="200px" height="300px"><br>
      <h3><%=item.getTitle()%></h3>
      <h3><%=item.getPrice()%> $</h3>
    </div>
  </div>
  <%}%>

  </body>
</html>
