<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/template/web/login.css' /> ">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
    <script src="https://kit.fontawesome.com/5ec3902171.js" crossorigin="anonymous"></script>
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
<!----------------Đăng nhập----------------------->
<div class="wrapper">
    <div class="form-box login">
        <h2>Đăng nhập</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="input-box">
                <span class="icon"></span>
                <input type="text" name="username" required>
                <label>Tài khoản,Email hoặc số điện thoại<a class="star">*</a></label>
            </div>

            <div class="input-box">
                <span class="icon"><i class="fa-solid fa-eye-slash"></i></span>
                <input type="password" name="password" required>
                <label>Mật khẩu<a class="star">*</a></label>
            </div>

            <div class="remember-fogot">
                <label><input type="checkbox">
                    Lưu mật khẩu đăng nhập
                </label>
            </div>

            <div class="login-register">
                <a href="${pageContext.request.contextPath}/forgot" class="register-link">Quên mật khẩu?</a>
            </div>

            <button style="margin-bottom: 10px" type="submit" class="btn">Đăng nhập
            </button>
        </form>
       <div style="display: flex;justify-content: space-around;">
           <div class="google">
               <button>
                   <i style="font-size: 30px" class="fa-brands fa-google"></i>
               </button>
           </div>
           <div class="facebook">
               <button>
                   <i style="font-size: 30px" class="fa-brands fa-facebook"></i>
               </button>
           </div>
       </div>

    </div>

</div>
<script src="login.js"></script>
</body>
</html>