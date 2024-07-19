<%--
  Created by IntelliJ IDEA.
  User: voduc
  Date: 7/19/2024
  Time: 3:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đặt vé xem phim</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #0F172A;
            color: white;
        }

        .header {
            border: 2px solid white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: #0f1525;
            position: fixed;
            bottom: 20px;
            /*right: 20px;*/
            background-color: #0F172A;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            height: 100px;
            width: 100%;
        }

        .movie-info h1 {
            margin: 0;
            font-size: 18px;
        }

        .movie-info p {
            margin: 5px 0 0;
            font-size: 14px;
            color: #888;
        }

        .timer {
            background-color: #ffd700;
            color: black;
            padding: 5px 10px;
            border-radius: 5px;
            font-weight: bold;
        }

        .total {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .book-ticket {
            position: fixed;
            bottom: 20px;
            right: 20px;
            background-color: #4a5580;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: background-color 0.3s, transform 0.2s;
        }

        .book-ticket:hover {
            background-color: #6a7f9a;
            transform: translateY(-2px);
        }

        .book-ticket:active {
            background-color: #3d4a63;
            transform: translateY(0);
        }

        .movie-info {
            display: flex;
            flex-direction: column;
            flex-wrap: nowrap;
            align-content: flex-start;
            justify-content: space-between;
            align-items: baseline;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="movie-info">
        <h1>${movie.movie_name}</h1>
        <h1 class="combo_info">COMBO:</h1>
        <h1 class="seat_info">GHẾ:</h1>

    </div>
    <div class="timer">
        <span>Thời gian giữ vé:</span>
        <span id="countdown">05:00</span>
    </div>
    <div class="total">
        <span>0 VND</span>
    </div>
    <button class="btn_order_submit">ĐẶT VÉ</button>
</div>


<script>
    // JavaScript will be inserted here
</script>
</body>
<script>
    function startCountdown(duration, display) {
        let timer = duration, minutes, seconds;
        setInterval(function () {
            minutes = parseInt(timer / 60, 10);
            seconds = parseInt(timer % 60, 10);

            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            display.textContent = minutes + ":" + seconds;

            if (--timer < 0) {
                timer = duration;
            }
        }, 1000);
    }

    window.onload = function () {
        let fiveMinutes = 60 * 5,
            display = document.querySelector('#countdown');
        startCountdown(fiveMinutes, display);
    };
</script>
</html>