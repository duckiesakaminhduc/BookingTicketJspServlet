<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/template/web/book_movie_style.css"/> ">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
    <link
            href="https://fonts.googleapis.com/css2?family=Anton&family=Josefin+Sans:ital,wght@0,100..700;1,100..700&display=swap"
            rel="stylesheet">
    </link>
    <script src="https://kit.fontawesome.com/5ec3902171.js" crossorigin="anonymous"></script>
    <title>Booking movie</title>
</head>

<style>
    /* Màu nền mặc định */
    .box-time {
        background-color: #F3EA28;
    }

    /* Màu nền khi được nhấp */
    .box-time.active {
        background-color: #34eb6e; /* Màu khác khi nhấp */
    }

    /* Màu nền của các phần tử con khi được nhấp */
    .box-time.active .date-time,
    .box-time.active .day-time,
    .box-time.active div {
        background-color: #0F172A; /* Màu khác khi nhấp cho các phần tử con */
    }


</style>
<body>
<%@include file="../../template/web/header/header.jsp" %>

<span style="display: none" id="movie_id">${movie.id}</span>
<div id="wrapper">

    <section class="sec__detail">
        <div class="detail">
            <div class="detail__img">
                <img style="border-radius: 10px" src="${movie.url_img}" alt="">
                <div class="attach">
                    <div class="type__movie">
                        <span class="txt">2d</span>
                        <span class="num">T16</span>
                    </div>
                </div>
            </div>
            <div class="detail__info">
                <div class="detail__info--title">
                    <h1>${movie.movie_name}</h1>
                </div>
                <ul class="detail__info--detail">
                    <li><i class="fa-solid fa-tag" style="color: #FFD43B;"></i><span class="category">Kinh di</span>
                    </li>
                    <li><i class="fa-solid fa-clock" style="color: #FFD43B;"></i><span
                            class="duration">${movie.duration}'</span></li>
                    <li><i class="fa-solid fa-earth-americas" style="color: #FFD43B;"></i><span
                            class="country">${movie.country}</span></li>
                    <li><i class="fa-solid fa-user-check" style="color: #FFD43B;"></i><span
                            class="recommend">${movie.recommend}.</span></li>
                </ul>
                <div class="detail__info--describe">
                    <h3>MÔ TẢ</h3>
                    <ul class="detail__info--describe--detail">
                        <li class="manager">Đạo diễn: ${movie.manager}</li>
                        <li class="performers">Diễn viên: ${movie.performers},...</li>
                        <li class="premiere">Khởi chiếu: ${premiere}</li>
                    </ul>
                </div>
                <div class="detail__info--content">
                    <h3>NỘI DUNG PHIM
                    </h3>
                    <p class="detail__info--content--movie">Hai pháp sư, một thầy phong thuỷ và một chuyên gia khâm
                        liệm cùng hợp lực khai quật ngôi mộ
                        bị nguyền rủa của một gia đình giàu có, nhằm cứu lấy sinh mạng hậu duệ cuối cùng trong dòng
                        tộc. Bí mật hắc ám của tổ tiên được đánh thức.</p>
                </div>
                <div class="detail__info--trailer"><a href="#">
                    <img src="../../template/assets/images/ic-play-circle-red.svg" alt=""><a href="#">Xem Trailer</a>
                </a></div>
            </div>
        </div>
    </section>
    <!--  -->
    <section class="sh__time--wrapper">
        <div class="shtime__header">
            <div class="shtime__header--title">
                <h1>LỊCH CHIẾU</h1>
            </div>
            <div class="shtime__header--timelist">
                <c:forEach var="item" items="${screenings}">
                    <div class="box-time btn schedule_btn">
                        <div style="border-radius: 5px" class="date-time">${item.day}</div>
                        <div style="border-radius: 5px" class="day-time">${item.day_of_week}</div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <div class="shtime__body">
            <div class="shtime__body--header">
                <h2>DANH SÁCH RẠP</h2>
                <div class="list__cinestar">
                    <i class="fa-solid fa-location-dot"></i>
                    <select id="list">
                        <option value="hcm">HỒ CHÍ MINH</option>
                        <option value="dalat">ĐÀ LẠT</option>
                        <option value="binhduong" selected>BÌNH DƯƠNG</option>
                    </select>
                </div>
            </div>
            <ul id="list_schedule">
                <%--                <li class="item__cinestar">--%>
                <%--                    <div class="title__cinestar" style="padding-top: 10px">--%>
                <%--                        <input type="radio" name="cinestar__checked" id="second" checked>--%>
                <%--                        <label for="second">--%>
                <%--                            <h2>Cinestar Quốc Thanh</h2>--%>
                <%--                        </label>--%>
                <%--                        <div class="collapse__shtime">--%>
                <%--                            <ul class="list__shtime">--%>
                <%--                                <li class="shtime__item">09:50</li>--%>
                <%--                                <li class="shtime__item">09:50</li>--%>
                <%--                                <li class="shtime__item">09:50</li>--%>
                <%--                                <li class="shtime__item">09:50</li>--%>
                <%--                                <li class="shtime__item">09:50</li>--%>
                <%--                            </ul>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </li>--%>

            </ul>
        </div>
    </section>
    <!--  -->
    <section class="ticket">
        <div class="ticket-choice">
            <h2>CHỌN LOẠI VÉ</h2>
        </div>
        <div class="wrapper__ticket--box">
            <div class="ticket__item">
                <div>NGƯỜI LỚN</div>
                <div>--- ĐƠN ---</div>
                <div class="value_ticket">45,000</div>
                <div class="content__bottom">
                    <div class="count">
                        <div class="minus_f">-</div>
                        <div class="amount_ticket count_f">0</div>
                        <div class="plus_f">+</div>
                    </div>
                </div>
            </div>
            <div class="ticket__item">
                <div>NGƯỜI LỚN</div>
                <div>--- ĐƠN ---</div>
                <div class="value_ticket">65,000</div>
                <div class="content__bottom">
                    <div class="count">
                        <div class="minus_s">-</div>
                        <div class="amount_ticket count_s">0</div>
                        <div class="plus_s">+</div>
                    </div>
                </div>
            </div>
            <div class="ticket__item">
                <div>NGƯỜI LỚN</div>
                <div>--- ĐÔI ---</div>
                <div class="value_ticket">95,000</div>
                <div class="content__bottom">
                    <div class="count">
                        <div class="minus_t">-</div>
                        <div class="amount_ticket count_t">0</div>
                        <div class="plus_t">+</div>
                    </div>
                </div>
            </div>
        </div>
        <span class="txt">Lưu ý: Mang CCCD hoặc thẻ HSSV khi đến rạp</span>
    </section>
</div>

<%--<div id="popup__wrapper" class="modal">--%>
<%--    <div class="content">--%>
<%--        Vui lòng chọn tối đa 8 vé--%>
<%--        <button class="noti__btn">--%>
<%--            <div class="txt">OK</div>--%>
<%--        </button>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="seat">
    <div class="seat__heading">
        <h2>CHỌN GHẾ</h2>
    </div>
    <div class="seat__block">
        <div class="seat__creen">
            <img src="../../template/assets/images/img-screen.png" alt="">
            <div class="txt">Màn hình</div>
        </div>
    </div>
    <!--  -->
    <div class="seat__main">
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">A</td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">A01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">A02</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">A03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">A04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">A05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">A06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">A07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">A08</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">B</td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">B01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">B02</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">B03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">B04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">B05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">B06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">B07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">B08</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">C</td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">C01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">C02</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">C03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">C04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">C05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">C06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">C07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">C08</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">D</td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">D01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">D02</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">D03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">D04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">D05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">D06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">D07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">D08</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">E</td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">E01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">E02</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">E03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">E04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">E05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">E06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">E07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">E08</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">F</td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">F01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">F02</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">F03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">F04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">F05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">F06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">F07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">F08</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">G</td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G02</span>
                    </div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G08</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G09</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">G10</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">H</td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H02</span>
                    </div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H08</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H09</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">H10</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">J</td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J02</span>
                    </div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J03</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J04</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J05</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J06</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J07</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J08</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J09</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">J10</span>
                    </div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">K</td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">K01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">K02</span>
                    </div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
            </tr>
        </div>
        <div class="seat__table">
            <tr class="seat__row">
                <td class="seat__name">L</td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">L01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">L02</span>
                    </div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">L01</span>
                    </div>
                </td>
                <td>
                    <div class="seat__single">
                        <img src="../../template/assets/images/seat-single.svg" alt="">
                        <span class="seate__single__name">L02</span>
                    </div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
                <td>
                    <div class="empty"></div>
                </td>
            </tr>
        </div>

    </div>
</div>
<div class="shtime__footer"></div>
<p>git hub</p>
<%@include file="../combo.jsp" %>
<div id="nav_bottom" style="display: none">
    <%@include file="../nav-bottom.jsp" %>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script src="<c:url value="/template/web/movie_detail.js" />"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="<c:url value="/views/web/movie_detail.js"/> "></script>

</html>