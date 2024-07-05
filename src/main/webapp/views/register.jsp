<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/template/web/login.css' /> ">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
</head>
<style>


</style>
<body>
<header>
    <h2 class="logo">Chọn rạp</h2>
    <nav class="navigation">
        <a href="#">Home</a>
        <a href="#">Khuyến mãi</a>
        <a href="#">Thuê sự kiện</a>
        <a href="#">Dịch vụ khác</a>
        <a href="# ">Giới thiệu</a>
    </nav>
</header>

<!----------------Đăng kí----------------------->
<div class="form-box register">
    <h2>Đăng Kí</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <p>${pageContext.request.contextPath}"</p>
        <div class="input-box">
            <span class="icon"></span>
            <input name="username" type="text" required>
            <label>Tên đăng nhập<a class="star">*</a></label>
        </div>

        <div class="input-box">
            <span class="icon"></span>
            <input name="email" type="email" required>
            <label>Email<a class="star">*</a></label>
        </div>

        <div class="input-box">
            <span class="icon"><i class="fa-solid fa-eye-slash"></i></span>
            <input name="password" type="password" required>
            <label>Mật khẩu<a class="star">*</a></label>
        </div>
        <div class="input-box">
            <span class="icon"><i class="fa-solid fa-eye-slash"></i></span>
            <input type="password" required>
            <label>Xác nhận mật khẩu<a class="star">*</a></label>
        </div>

        <button type="submit" class="btn">Đăng kí
        </button>
        <div class="login-register">Bạn đã có tài khoản
            <a href="#" class="register-link">Đăng nhập</a>
        </div>
    </form>
</div>

<!---------------- End đăng kí----------------------->


</div>
<script src="login.js"></script>
</body>
</html>