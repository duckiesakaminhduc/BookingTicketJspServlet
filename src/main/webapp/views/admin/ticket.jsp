<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
    <script src="https://kit.fontawesome.com/5ec3902171.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/2.0.8/js/dataTables.min.js"></script>
    <title>Danh sách vé</title>
</head>
<body>
<%@include file="../../template/web/header/header.jsp" %>
<div class="container">
    <table id="ticketTable" class="display">
        <thead>
        <tr>
            <th>ID</th>
            <th>Ngày tạo</th>
            <th>ID người dùng</th>
            <th>ID phòng</th>
            <th>ID combo</th>
            <th>ID suất chiếu</th>
            <th>Tổng giá</th>
            <th>ID rạp</th>
            <th>ID phim</th>
        </tr>
        </thead>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    $(document).ready(function() {
        $('#ticketTable').DataTable({
            ajax: {
                url: "http://localhost:8080/BookingTicket/user/ticket",
                type: "GET",
                dataSrc: "" // Vì dữ liệu trả về là một mảng, không có khóa bao bọc
            },
            columns: [
                { data: "id" },
                { data: "create_at" },
                { data: "user_id" },
                { data: "room_id" },
                { data: "combo_id" },
                { data: "screening_id" },
                { data: "total_price" },
                { data: "theater_id" },
                { data: "movie_id" }
            ],
            language: {
                url: "//cdn.datatables.net/plug-ins/1.10.25/i18n/Vietnamese.json"
            }
        });
    });
</script>
</html>