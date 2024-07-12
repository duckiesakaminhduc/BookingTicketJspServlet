<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script
            src="https://kit.fontawesome.com/5ec3902171.js"
            crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="<c:url value="/views/admin/screening/screening.css"/> "/>

<%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>
    <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="<c:url value="/views/admin/screening/css/mobiscroll.javascript.min.css"/> ">
    <script src="<c:url value="/views/admin/screening/js/mobiscroll.javascript.min.js"/> "></script>
    <script src="<c:url value="/views/admin/screening/js/moment-with-locales.js"/> "></script>
    <title>Title</title>
</head>

<body>

<div class="container">

    <div class="d-flex justify-content-between align-items-center">
        <div>
            <label for="room">Chọn phòng:</label>

            <select name="room" id="room">
                <option value="0" selected>Lựa chọn</option>
                <option value="1">Phòng 1</option>
                <option value="2">Phòng 2</option>
                <option value="3">Phòng 3</option>
                <option value="4">Phòng 4</option>
            </select>
        </div>



        <button style="margin-left: 20px" class="btn bg-primary text-light">
            LỌC
        </button>
    </div>

    <!-- show image -->
    <div id="list_movies" style="display: flex; flex-direction: row;gap: 10px;">

        <div class="movie__item">
        </div>

    </div>

    <div class="table">
        <table class="table table-bordered text-center">
            <thead>
            <tr class="bg-light-gray">
                <th class="text-uppercase">Monday</th>
                <th class="text-uppercase">Tuesday</th>
                <th class="text-uppercase">Wednesday</th>
                <th class="text-uppercase">Thursday</th>
                <th class="text-uppercase">Friday</th>
                <th class="text-uppercase">Saturday</th>
                <th class="text-uppercase">Sunday</th>
            </tr>
            </thead>
            <tbody id="scheduleBody">
            <tr
                    style="
                height: 90px;
                width: 90px;
                position: relative;
                margin-bottom: 50px;
                padding-bottom: 50px;
              "
            >
                <td
                        style="position: relative"
                        id="d1"
                        ondrop="drop(event)"
                        ondragover="allowDrop(event)"
                >
                    <div
                            class="border margin-10px-bottom font-size14"
                            style="bottom: -27px; width: 100%; left: 0px"
                    >
                        <span class="time">08:00</span>
                    </div>
                </td>

                <td
                        style="position: relative"
                        id="d2"
                        ondrop="drop(event)"
                        ondragover="allowDrop(event)"
                >
                    <div
                            class="border margin-10px-bottom font-size14"
                            style="bottom: -27px; width: 100%; left: 0px"
                    >
                        <span class="time">08:00</span>
                    </div>
                </td>
                <td
                        style="position: relative"
                        id="d3"
                        ondrop="drop(event)"
                        ondragover="allowDrop(event)"
                >
                    <div
                            class="border margin-10px-bottom font-size14"
                            style="bottom: -27px; width: 100%; left: 0px"
                    >
                        <span class="time">08:00</span>
                    </div>
                </td>
                <td
                        style="position: relative"
                        id="d4"
                        ondrop="drop(event)"
                        ondragover="allowDrop(event)"
                >
                    <div
                            class="border margin-10px-bottom font-size14"
                            style="bottom: -27px; width: 100%; left: 0px"
                    >
                        <span class="time">08:00</span>
                    </div>
                </td>
                <td
                        style="position: relative"
                        id="d5"
                        ondrop="drop(event)"
                        ondragover="allowDrop(event)"
                >
                    <div
                            class="border margin-10px-bottom font-size14"
                            style="bottom: -27px; width: 100%; left: 0px"
                    >
                        <span class="time">08:00</span>
                    </div>
                </td>
                <td
                        style="position: relative"
                        id="d6"
                        ondrop="drop(event)"
                        ondragover="allowDrop(event)"
                >
                    <div
                            class="border margin-10px-bottom font-size14"
                            style="bottom: -27px; width: 100%; left: 0px"
                    >
                        <span class="time">08:00</span>
                    </div>
                </td>
                <td
                        style="position: relative"
                        id="d7"
                        ondrop="drop(event)"
                        ondragover="allowDrop(event)"
                >
                    <div
                            class="border margin-10px-bottom font-size14"
                            style="bottom: -27px; width: 100%; left: 0px"
                    >
                        <span class="time">08:00</span>
                    </div>
                </td>
            </tr>
            <div
                    class="plus btn"
                    style="font-size: 40px;"
            >
                <i class="fa-solid fa-square-plus"></i>
            </div>
            </tbody>
        </table>
    </div>
    <div class="text-center">
        <button type="button" class="btn btn-success">Success</button>
    </div>
</div>
</body>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<%--<script src="${pageContext.request.contextPath}/views/admin/screening/screening.js"></script>--%>
<script src="<c:url value="/views/admin/screening/screening.js"/> "></script>
</html>
