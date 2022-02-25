<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD ANNOUNCEMENT</title>
</head>
<body>

<h1>WELCOME ADD ANNOUNCEMENT PAGE</h1>

<div>
    <form action="/addAnnouncement" method="post" enctype="multipart/form-data">
        <input type="text" name="title" placeholder="title"><br>
        <input type="text" name="price" placeholder="price"></input><br>
        <input type="text" name="category_id" placeholder="category_id"><br>
        <input type="file" name="pic_url" placeholder="pic_url"/> <br>
        <input type="text" name="user_id" placeholder="user_id"><input type="submit" value="ADD ANNOUNCEMENT">
    </form>
</div>

</body>
</html>
