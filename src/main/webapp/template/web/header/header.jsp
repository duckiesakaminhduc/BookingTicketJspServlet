<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cinestar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .navbar {
            background-color: #0F172A;
        }
        .navbar-brand img {
            height: 30px;
        }
        .nav-link, .navbar-text {
            color: white !important;
        }
        .btn-warning {
            background-color: #ffd700;
            border-color: #ffd700;
        }
        .btn-danger {
            background-color: #ff4136;
            border-color: #ff4136;
        }
        body {
            font-family: 'Arial, Helvetica, sans-serif';
        }


    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="https://cinestar.com.vn/_next/image/?url=%2Fassets%2Fimages%2Fheader-logo.png&w=1920&q=75" alt="Cinestar"></a>
        <div class="d-flex">
            <button class="btn btn-warning me-2">ĐẶT VÉ NGAY</button>
            <button class="btn btn-danger">ĐẶT BẮP NƯỚC</button>
        </div>
        <form class="d-flex mx-auto">
            <input class="form-control me-2" type="search" placeholder="Tìm phim, rạp" aria-label="Search">
            <button class="btn btn-outline-light" type="submit"><i class="fas fa-search"></i></button>
        </form>
        <div class="navbar-text">
            <i class="fas fa-user me-2"></i>
            VÕ ĐỨC...
        </div>
        <div class="navbar-text ms-3">
            <span class="me-2">VN</span>
            <i class="fas fa-chevron-down"></i>
        </div>
    </div>
</nav>
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="#"><i class="fas fa-map-marker-alt me-2"></i>Chọn rạp</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><i class="far fa-calendar-alt me-2"></i>Lịch chiếu</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Khuyến mãi</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Thuê sự kiện</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Tất cả các giải trí</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Giới thiệu</a>
            </li>
        </ul>
    </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>