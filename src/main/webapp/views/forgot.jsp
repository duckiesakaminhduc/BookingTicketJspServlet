<%--
  Created by IntelliJ IDEA.
  User: voduc
  Date: 7/6/2024
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h2>Reset Your Password </h2>
    <p>
        Please enter your login email, we'll send a new random password to your inbox:
    </p>

    <form id="resetForm" action="${pageContext.request.contextPath}/forgot" method="post">
        <table>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" size="20"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Send me new password</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
