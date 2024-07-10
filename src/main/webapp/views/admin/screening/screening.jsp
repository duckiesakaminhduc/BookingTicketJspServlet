<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script
            src="https://kit.fontawesome.com/5ec3902171.js"
            crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/screening/addphim.cssddphim.css"/>
    <title>Title</title>
</head>
<body>
<!--
<div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<div id="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<div id="div3" ondrop="drop(event)" ondragover="allowDrop(event)"></div> -->

<div
        src="avatar-01.jpg"
        alt=""
        id="drag1"
        draggable="true"
        ondragstart="drag(event)">
    child
</div>
<div class="container">
    <div class="text-center">
        <img src="img/content/timetable.png" class="mb-1" alt=""/>
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
                        <span class="time">Time</span>
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
                        <span class="time">Time</span>
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
                        <span class="time">Time</span>
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
                        <span class="time">Time</span>
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
                        <span class="time">Time</span>
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
                        <span class="time">Time</span>
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
                        <span class="time">Time</span>
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
</div>
</body>

<script>
    function allowDrop(ev) {
        ev.preventDefault();
    }

    function drag(ev) {
        ev.dataTransfer.setData("text", ev.target.id);
    }

    function drop(ev) {
        ev.preventDefault();
        var data = ev.dataTransfer.getData("text");
        const dragElement = document.getElementById(data);
        if (dragElement.id == "drag1") {
            const clone = dragElement.cloneNode(true);
            clone.id = generateUUID();

            ev.target.appendChild(clone);
            clone.addEventListener("ondragstart", (ev) => {
                ev.dataTransfer.setData("text", ev.target.id);
            });
            clone.setAttribute("draggable", "true");
        } else {
            ev.target.appendChild(dragElement);
        }
    }

    function generateUUID() {
        return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(
            /[xy]/g,
            function (c) {
                var r = (Math.random() * 16) | 0,
                    v = c == "x" ? r : (r & 0x3) | 0x8;
                return v.toString(16);
            }
        );
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/views/admin/screening/screening.js"></script>
</html>
