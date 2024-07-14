
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<a href="common/web/footer.jsp">Hello Servlet</a>
<a href="views/login.jsp">login</a>
<a href="views/register.jsp">login</a>

<a href="views/web/movie_detail.jsp">booking ticket</a>
<a href="index.jsp">index</a>
<a href="common/">Hello Servlet</a>
<a href="views/google.jsp">google</a>
<a href="views/forgot.jsp">Forgot</a>

<h1>ID: <%= request.getAttribute("id") %>
</h1>
<h1> <%= request.getAttribute("name") %></h1>
<h1><%= request.getAttribute("email") %></h1>
</body>
</html>