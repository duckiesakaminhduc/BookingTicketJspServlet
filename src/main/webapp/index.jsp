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
<body>
<section class="container">
    <div class="card__container swiper">
        <div class="card__content">
            <div class="swiper-wrapper">
<%--                <article class="card__article swiper-slide">--%>
<%--                    <div class="card__image">--%>
<%--                        <img src="assets/img/avatar-1.png" alt="image" class="card__img">--%>
<%--                        <div class="card__shadow"></div>--%>
<%--                    </div>--%>

<%--                    <div class="card__data">--%>
<%--                        <h3 class="card__name">Kell Dawx</h3>--%>
<%--                        <p class="card__description">--%>
<%--                            Passionate about development and design,--%>
<%--                            I carry out projects at the request of users.--%>
<%--                        </p>--%>

<%--                        <a href="#" class="card__button">View More</a>--%>
<%--                    </div>--%>
<%--                </article>--%>

<%--                <article class="card__article swiper-slide">--%>
<%--                    <div class="card__image">--%>
<%--                        <img src="assets/img/avatar-2.png" alt="image" class="card__img">--%>
<%--                        <div class="card__shadow"></div>--%>
<%--                    </div>--%>

<%--                    <div class="card__data">--%>
<%--                        <h3 class="card__name">Lotw Fox</h3>--%>
<%--                        <p class="card__description">--%>
<%--                            Passionate about development and design,--%>
<%--                            I carry out projects at the request of users.--%>
<%--                        </p>--%>

<%--                        <a href="#" class="card__button">View More</a>--%>
<%--                    </div>--%>
<%--                </article>--%>

<%--                <article class="card__article swiper-slide">--%>
<%--                    <div class="card__image">--%>
<%--                        <img src="assets/img/avatar-3.png" alt="image" class="card__img">--%>
<%--                        <div class="card__shadow"></div>--%>
<%--                    </div>--%>

<%--                    <div class="card__data">--%>
<%--                        <h3 class="card__name">Sara Mit</h3>--%>
<%--                        <p class="card__description">--%>
<%--                            Passionate about development and design,--%>
<%--                            I carry out projects at the request of users.--%>
<%--                        </p>--%>

<%--                        <a href="#" class="card__button">View More</a>--%>
<%--                    </div>--%>
<%--                </article>--%>

<%--                <article class="card__article swiper-slide">--%>
<%--                    <div class="card__image">--%>
<%--                        <img src="assets/img/avatar-4.png" alt="image" class="card__img">--%>
<%--                        <div class="card__shadow"></div>--%>
<%--                    </div>--%>

<%--                    <div class="card__data">--%>
<%--                        <h3 class="card__name">Jenny Wert</h3>--%>
<%--                        <p class="card__description">--%>
<%--                            Passionate about development and design,--%>
<%--                            I carry out projects at the request of users.--%>
<%--                        </p>--%>

<%--                        <a href="#" class="card__button">View More</a>--%>
<%--                    </div>--%>
<%--                </article>--%>

<%--                <article class="card__article swiper-slide">--%>
<%--                    <div class="card__image">--%>
<%--                        <img src="assets/img/avatar-5.png" alt="image" class="card__img">--%>
<%--                        <div class="card__shadow"></div>--%>
<%--                    </div>--%>

<%--                    <div class="card__data">--%>
<%--                        <h3 class="card__name">Lexa Kin</h3>--%>
<%--                        <p class="card__description">--%>
<%--                            Passionate about development and design,--%>
<%--                            I carry out projects at the request of users.--%>
<%--                        </p>--%>

<%--                        <a href="#" class="card__button">View More</a>--%>
<%--                    </div>--%>
<%--                </article>--%>
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

