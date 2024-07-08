<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <title>Document</title>
</head>
<body>
<!-- Header -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Logo</a>
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Liên hệ</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <nav class="col-md-3 col-lg-2 d-md-block sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="#"> Danh mục 1 </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"> Danh mục 2 </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"> Danh mục 3 </a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Main Content -->
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div
                    class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"
            >
                <h1 class="h2">Nội dung chính</h1>
            </div>
            <p>Đây là phần nội dung chính của trang web.</p>


            <div>
                <canvas id="myChart"></canvas>
            </div>

        </main>
    </div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
<script>

    const ctx = document.querySelector("#myChart");
    $(document).ready(function () {
        $.ajax({
            url: "/BookingTicket/admin/revenue",
            type: "GET",
            dataType: "json",
            success: function (data) {
                let labels = [];
                let datas = [];
                console.log(labels);
                console.log(datas);

                data.map(item => {
                    labels.push(item.theater_name);
                    datas.push(item.total_price);
                })
                new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Đơn vị: VND',
                            data: datas,
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });
            }
        });
    });


</script>

</html>
