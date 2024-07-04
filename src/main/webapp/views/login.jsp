<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/template/web/login.css' /> ">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
</head>
<style>
    body{
        background-image: url("../template/assets/images/background-login.jpg");
    }

</style>
<body>
<header>
    <h2 class = "logo">Chọn rạp</h2>
    <nav class = "navigation">
        <a href = "#">Home</a>
        <a href = "#">Khuyến mãi</a>
        <a href = "#">Thuê sự kiện</a>
        <a href = "#">Dịch vụ khác</a>
        <a href = "# ">Giới thiệu</a>
    </nav>
</header>
<!----------------Đăng nhập----------------------->
<div class = "wrapper">
    <div class = "form-box login">
        <h2>Đăng nhập</h2>
        <form action="#">
            <div class = "input-box">
                <span class = "icon"></span>
                <input type = "email" required>
                <label>Tài khoản,Email hoặc số điện thoại<a class= "star">*</a></label>
            </div>

            <div class = "input-box">
                <span class = "icon"><i class="fa-solid fa-eye-slash"></i></span>
                <input type = "email" required>
                <label>Mật khẩu<a class= "star">*</a></label>
            </div>

            <div class = "remember-fogot">
                <label><input type = "checkbox">
                    Lưu mật khẩu đăng nhập
                </label>
            </div>

            <div class = "login-register">
                <a href = "#" class = "register-link">Quên mật khẩu?</a>
            </div>

            <button type="submit" class = "btn">Đăng nhập
            </button>
            <div class = "login-register">Bạn đã có tài khoản
                <a href = "#" class = "register-link">Đăng kí</a>
            </div>
        </form>
    </div>
    <!----------------End Đăng nhập----------------------->


    <!----------------Đăng kí----------------------->
    <div class = "form-box register">
        <h2>Đăng Kí</h2>
        <form action="#">
            <div class = "input-box">
                <span class = "icon"></span>
                <input type = "text" required>
                <label>Họ và tên<a class= "star">*</a></label>
            </div>

            <div class = "input-box">
                <span class = "icon"></span>
                <input type = "date" required>
                <label>Ngày sinh<a class= "star">*</a></label>
            </div>

            <div class = "input-box">
                <span class = "icon"></span>
                <input type = "tel" required>
                <label>Số điện thoại<a class= "star">*</a></label>
            </div>

            <div class = "input-box">
                <span class = "icon"></span>
                <input type = "text" required>
                <label>Tên đăng nhập<a class= "star">*</a></label>
            </div>

            <div class = "input-box">
                <span class = "icon"></span>
                <input type = "text" required>
                <label>CCCD/CMND<a class= "star">*</a></label>
            </div>

            <div class = "input-box">
                <span class = "icon"></span>
                <input type = "email" required>
                <label>Email<a class= "star">*</a></label>
            </div>

            <div class = "input-box">
                <span class = "icon"><i class="fa-solid fa-eye-slash"></i></span>
                <input type = "email" required>
                <label>Mật khẩu<a class= "star">*</a></label>
            </div>
            <div class = "input-box">
                <span class = "icon"><i class="fa-solid fa-eye-slash"></i></span>
                <input type = "email" required>
                <label>Xác nhận mật khẩu<a class= "star">*</a></label>
            </div>


            <div class = "remember-fogot">
                <label><input type = "checkbox">
                    Khách hàng đã đồng ý các điều khoản,điều kiện của thành viên Cinestar
                </label>
            </div>

            <button type="submit" class = "btn">Đăng kí
            </button>
            <div class = "login-register">Bạn đã có tài khoản
                <a href = "#" class = "register-link">Đăng nhập</a>
            </div>
        </form>
    </div>

    <!---------------- End đăng kí----------------------->


</div>
<script src="login.js"></script>
</body>
</html>