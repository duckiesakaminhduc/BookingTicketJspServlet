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
    <script
            src="https://kit.fontawesome.com/5ec3902171.js"
            crossorigin="anonymous"
    ></script>
    <link
            rel="stylesheet"
            href="https://cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/2.0.8/js/dataTables.min.js"></script>
    <title>Document</title>
    <style>
        body {
            display: flex;
        }

        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            height: 100vh;
            width: 250px;
            background-color: #f8f9fa;
            border-right: 1px solid #dee2e6;
            overflow-y: auto; /* Cho phép cuộn sidebar nếu nội dung quá dài */
        }

        .content {
            margin-left: 250px;
            padding: 20px;
            width: calc(100% - 250px);
            overflow-y: auto; /* Cho phép cuộn nội dung nếu quá dài */
        }

        .overlay {
            display: none; /* Ban đầu ẩn */
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* Màu nền mờ */
            justify-content: center;
            align-items: center;
            z-index: 1000; /* Đảm bảo lớp phủ nằm trên các phần tử khác */
            overflow-y: auto; /* Cho phép cuộn nội dung nếu quá dài */

        }

    </style>
</head>
<body>
<!-- Sidebar -->
<nav class="sidebar">
    <div class="position-sticky pt-3">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" id="revenue" href="#"> Doanh thu </a>
            </li>
            <li class="nav-item">
                <a
                        class="nav-link manage1"
                        data-bs-toggle="collapse"
                        id="management"
                        href="#managelist"
                >
                    Quản lí
                </a>
                <ul class="collapse" id="managelist">
                    <li><a href="#">Rap 1</a></li>
                    <li><a href="#">Rap 2</a></li>
                    <li><a href="#">Rap 3</a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"> Danh mục 3 </a>
            </li>
        </ul>
    </div>
</nav>

<!-- Main Content -->
<div class="content">
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

    <div id="chartContent">
        <label for="selectBox1">Tổng doanh thu</label>
        <select id="selectBox1">
            <option value="Tháng này">Tháng này</option>
            <option value="Tháng trước">Tháng trước</option>
            <option value="6 Tháng">6 Tháng</option>
        </select>
        <div id="result1"></div>

        <label for="theater"> Chọn rạp</label>
        <form action="" id="theater">
            <input type="checkbox" id="t1" name="x2" value="CINESTAR HUẾ"/>
            <label for="t1">CINESTAR HUẾ</label><br/>
            <input type="checkbox" id="t2" name="x2" value="CINESTAR SINH VIÊN"/>
            <label for="t2">CINESTAR SINH VIÊN</label><br/>
            <input
                    type="checkbox"
                    id="t3"
                    name="x2"
                    value="CINESTAR HAI BÀ TRƯNG"
            />
            <label for="t3">CINESTAR HAI BÀ TRƯNG</label><br/>
            <input type="checkbox" id="t4" name="x2" value="CINESTAR ĐÀ LẠT"/>
            <label for="t4">CINESTAR ĐÀ LẠT</label><br/>
        </form>
        <div id="result2"></div>
        <div
                class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"
        >
            <h1 class="h2">Doanh thu</h1>
        </div>
        <p>Vui lòng chọn rạp.</p>

        <div>
            <canvas id="myChart"></canvas>
        </div>
    </div>

    <div id="managementContent" style="display: none">
        <h2>Quản lí</h2>

        <table id="myTable" class="display" style="width: 100%;">
            <thead>
            <tr>
                <th style="">ID</th>
                <th>Tên phim</th>
                <th>Ngày thêm</th>
                <th>Người thêm</th>
                <th>Trạng thái</th>
                <th>Xóa</th>
                <th>Sửa</th>
            </tr>
            </thead>
            <tbody id="tbd">
            <tr>
                <td>1</td>
                <td>Donna Snider</td>
                <td>Customer Support</td>
                <td>New York</td>
                <td>27</td>
                <td>
                    <div class="btn">
                        <i class="fa-solid fa-trash" style="font-size: 20px"></i>
                    </div>
                </td>
                <td>
                    <div class="btn">
                        <i class="fa-solid fa-pen" style="font-size: 20px"></i>
                    </div>
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <th style="">ID</th>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>

<div class="overlay" id="edit">
    <div class="popup" class="container">
        <div class="row">
            <div
                    class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 layout-spacing"
            >
                <div class="statbox widget box box-shadow">
                    <div class="widget-content widget-content-area add-category">
                        <div class="row">
                            <div class="mx-xl-auto col-xl-10 col-md-12">
                                <div class="card card-default">
                                    <div class="card-heading">
                                        <h2
                                                class="card-title p-1"
                                                style="float: right;"
                                        >
                                            <div id="close">
                                                <div class="btn" style="font-size: 50px">
                                                    <i class="fa-solid fa-rectangle-xmark"></i>
                                                </div>
                                            </div>
                                        </h2>
                                    </div>
                                    <div class="card-body">
                                        <div class="card-body">
                                            <form class="form-horizontal">
                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4">Tên phim :</label>
                                                        <div class="col-md-8">
                                                            <input
                                                                    id="movie_name"
                                                                    class="form-control"
                                                                    name="movie_name"
                                                                    type="text"
                                                            />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4">Trạng thái :</label>
                                                        <div class="col-md-8">
                                                            <select

                                                                    class="form-control form-custom"
                                                                    name="is_active"
                                                            >
                                                                <option value="">Lựa chọn</option>
                                                                <option value="yes">Đang chiếu</option>
                                                                <option value="no">Sắp chiếu</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4">Ảnh bìa :</label>
                                                        <div class="col-md-8">
                                                            <div class="input-group mb-3">
                                                                <div class="custom-file">
                                                                    <input
                                                                            type="file"
                                                                            class="form-control-file"
                                                                    />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4">Quốc gia :</label>
                                                        <div class="col-md-8">
                                                            <input
                                                                    id="country"
                                                                    class="form-control"
                                                                    name="country"
                                                                    type="text"
                                                            />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4">Thời lượng :</label>
                                                        <div class="col-md-8">
                                                            <input
                                                                    id="duration"
                                                                    class="form-control"
                                                                    name="duration"
                                                                    type="number"
                                                                    min="0"
                                                            />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4">Đạo diễn :</label>
                                                        <div class="col-md-8">
                                                            <input
                                                                    id="manager"
                                                                    class="form-control"
                                                                    name="manager"
                                                                    type="text"
                                                            />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4">Diễn viên :</label>
                                                        <div class="col-md-8">
                                                            <input
                                                                    id="actor"
                                                                    class="form-control"
                                                                    name="performers"
                                                                    type="text"
                                                            />
                                                            <ul
                                                                    id="actorList"
                                                                    style="list-style: none"
                                                            ></ul>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4">Khuyến cáo :</label>
                                                        <div class="col-md-8">
                                                            <input
                                                                    id="recommend"
                                                                    class="form-control"
                                                                    name="recommend"
                                                                    type="text"
                                                            />
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group mb-4">
                                                    <div class="row">
                                                        <label class="col-md-4" for="event-date_1"
                                                        >Ngày công chiếu:</label
                                                        >
                                                        <input
                                                                class="col-md-8"
                                                                type="date"
                                                                id="event-date_1"
                                                                name="event-date_1"
                                                                value="2024-07-22"
                                                                min="2024-01-01"
                                                                max="2024-12-31"
                                                        />
                                                    </div>
                                                </div>


                                                <div class="align-center">
                                                    <input
                                                            value="Submit"
                                                            class="btn mt-5 mb-4"
                                                            type="submit"
                                                    />
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div
                    class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 layout-spacing"
            >
                <div class="statbox widget box box-shadow">
                    <div class="widget-header">
                        <div class="row">
                            <div class="col-xl-12 col-md-12 col-sm-12 col-12">
                                <h4>Add Sub Categories</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/chart.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
<script>

    let chartInstance = null;
    let arr_color = ['#fcba03', '#24fc03', '#03a1fc', '#d40f1c'];
    const ctx = document.querySelector("#myChart");

    function updateData() {
        var selected_x1 = $('#selectBox1').val();
        var selected_x2 = [];
        $('input[name="x2"]:checked').each(function () {
            selected_x2.push($(this).val());
        });

        $.ajax({
            url: "${pageContext.request.contextPath}/admin/revenue",
            type: "POST",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                months: selected_x1,
                theaters: selected_x2
            }),
            dataType: "json",
            success: function (data) {
                let x = new Set();
                let y = new Set();
                let labels = new Set();
                let arrX = [];
                let arrY = [];

                data.map(item => {
                    x.add(item.theater_name);
                    y.add(item.total_price);
                    labels.add(item.month);
                });

                arrX = Array.from(x);
                arrY = Array.from(y);


                let cottong = Array.from(labels);
                // console.log("cottong", cottong);

                let data_item = [];

                for (let i = 0; i < arrX.length; i++) {
                    data_item[i] = [];
                    for (let j = 0; j < cottong.length; j++) {
                        let item = data.find(item => item.theater_name === arrX[i] && item.month === cottong[j]);
                        data_item[i].push(item.total_price);
                    }
                }
                // console.log(data_item)
                // Create datasets for chart
                let datasets = [];
                for (let i = 0; i < arrX.length; i++) {
                    datasets.push({
                        label: arrX[i],
                        backgroundColor: arr_color[i],
                        fill: true,
                        data: data_item[i],
                        borderColor: "#ffffff",
                        borderWidth: 1
                    });
                }

                // Kiểm tra và hủy biểu đồ cũ trước khi tạo biểu đồ mới
                if (chartInstance !== null) {
                    chartInstance.destroy();
                }

                chartInstance = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: cottong,
                        datasets: datasets
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
    }


    $(document).ready(function () {
        // Gọi updateData khi trang được tải
        updateData();

        // Gắn sự kiện change cho select box và checkboxes
        $('#selectBox1, input[name="x2"]').change(function () {
            updateData();
        });

        // Sự kiện click cho phần tử "Quản lí"
        $('#management').click(function (e) {
            e.preventDefault();
            $('#chartContent').hide();
            $('#managementContent').show();
        });

        // Sự kiện click cho phần tử "Doanh thu"
        $('#revenue').click(function (e) {
            e.preventDefault();
            $('#chartContent').show();
            $('#managementContent').hide();
        });

        var table = $('#myTable').DataTable({
            serverSide: true,
            processing: true,
            ajax: {
                url: '${pageContext.request.contextPath}/admin/theater',
                type: "GET",
            },
            "columns": [
                {"data": "id"},
                {"data": "movie_name"},
                {"data": "create_at"},
                {"data": "create_by"},
                {
                    "data": "status",
                    "render": function (data, type, row) {
                        let statusText = '';
                        switch (data) {
                            case 0:
                                statusText = 'Hết chiếu';
                                break;
                            case 1:
                                statusText = 'Đang chiếu';
                                break;
                            case 2:
                                statusText = 'Sắp chiếu';
                                break;
                            default:
                                statusText = 'Unknown';
                                break;
                        }
                        return statusText;
                    }
                },
                {
                    "data": null,
                    "render": function (data, type, row) {
                        return '<div class="btn delete_btn"><i class=" fa-solid fa-trash" style="font-size: 20px"></i></div>';
                    }
                },
                {
                    "data": null,
                    "render": function (data, type, row) {
                        return '<div class="btn edit_btn"><i class=" fa-solid fa-pen" style="font-size: 20px"></i></div>';
                    }
                },

            ]
        });

        $('#tbd').on('click', 'tr', (e) => {
            // id= table.row(e.currentTarget).data().id;
            // console.log("id",id)
        })
        $("#close").on('click', function () {
            $('#edit').hide();
        })

        $('#myTable').on('draw.dt', function () {
            $('.edit_btn').click(function (e) {
                $('#edit').show();
                let tr = $(this).closest('tr');
                let movie_id = tr.find('td:first').text().trim();
                // console.log(movie_id)
                $.ajax({
                    url: `admin/movie?movie_id=` + movie_id,
                    type: "GET",
                    success: function (data) {
                        editForm(data);
                    }
                })
            });

            $('.delete_btn').click(function (e){
                let tr = $(this).closest('tr');
                let movie_id = tr.find('td:first').text().trim();
                $.ajax({
                    url:`admin/delete/movie`,
                    type:"POST",
                    data: {movie_id:movie_id},
                    success:function (e){
                        tr.remove();
                    }
                })
            })
        });

        function editForm(data) {
            $('#movie_name').val(data.movie_name);
            String
            stt = "";
            switch (data.status) {
                case 1:
                    stt = "Đang chiếu"
                    break;
                case 2:
                    stt = "Sắp chiếu"
                    break;
                default:
                    break;
            }
            $('select[name="is_active"]').val(stt);
            $('#country').val(data.country);
            $('#duration').val(data.duration);
            $('#manager').val(data.manager);
            $('#actor').val(data.performers);
            $('#recommend').val(data.recommend);

        }
    });


</script>

</html>
