<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--=============== REMIXICONS ===============-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/3.5.0/remixicon.css" crossorigin="">
    <!--=============== SWIPER CSS ===============-->
    <link rel="stylesheet" href="<c:url value='/template/web/css/swiper-bundle.min.css' />">
    <!--=============== CSS ===============-->
    <link rel="stylesheet" href="<c:url value='/template/web/css/styles.css' />">
    <title>Responsive card slider - Bedimcode</title>
</head>
<style>
    * {
        background-color: #0f172a;
    }
    .banner {
       position: relative;
    }
</style>
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


<section class="banner">
    <div class="container">
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://cinestar.com.vn/_next/image/?url=https%3A%2F%2Fapi-website.cinestar.com.vn%2Fmedia%2FMageINIC%2Fbannerslider%2Fbap-nuoc-onl.jpg&w=1920&q=75" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="https://cinestar.com.vn/_next/image/?url=https%3A%2F%2Fapi-website.cinestar.com.vn%2Fmedia%2FMageINIC%2Fbannerslider%2F1215wx365h_1_.jpg&w=1920&q=75" class="d-block w-100" alt="...">
                </div>

            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
</section>

<div class="text-center "><h1 class="mb-0 text-white fw-bold">PHIM ĐANG CHIẾU</h1></div>
<section class="">
    <div class="card__container swiper">
        <div class="card__content">
            <div class="swiper-wrapper">
            </div>
        </div>

        <!-- Navigation buttons -->
        <div class="swiper-button-next">
            <i class="ri-arrow-right-s-line"></i>
        </div>

        <div class="swiper-button-prev">
            <i class="ri-arrow-left-s-line"></i>
        </div>

        <!-- Pagination -->
        <div class="swiper-pagination"></div>
    </div>
</section>

<!--=============== SWIPER JS ===============-->
<script src="<c:url value='/template/web/js/swiper-bundle.min.js'/>"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
<!--=============== MAIN JS ===============-->
<script src="<c:url value='/template/web/js/main.js'/>"></script>
<script src="<c:url value='/index.js'/>"></script>

