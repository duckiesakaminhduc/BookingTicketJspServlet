<%@taglib uri="http://cloudinary.com/jsp/taglib" prefix="cl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>

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
                                <div class="card-heading bg-primary">
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

                                        <form action="${pageContext.request.contextPath}/admin/addmovie" method="POST"
                                              class="form-horizontal">
                                            <div class="form-group mb-4">
                                                <div class="row">
                                                    <label class="col-md-4">Tên phim :</label>
                                                    <div class="col-md-8">
                                                        <input id="movie_name" class="form-control" name="movie_name"
                                                               type="text"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group mb-4">
                                                <div class="row">
                                                    <label class="col-md-4">Trạng thái :</label>
                                                    <div class="col-md-8">
                                                        <select class="form-control form-custom" name="status">
                                                            <option value="none">Lựa chọn</option>
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
                                                                <button id="upload_widget" class="cloudinary-button">
                                                                    Upload files
                                                                </button>
                                                                <input name="img_url" id="img_url" type="text">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group mb-4">
                                                <div class="row">
                                                    <label class="col-md-4">Quốc gia :</label>
                                                    <div class="col-md-8">
                                                        <input id="country" class="form-control" name="country"
                                                               type="text"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group mb-4">
                                                <div class="row">
                                                    <label class="col-md-4">Thời lượng :</label>
                                                    <div class="col-md-8">
                                                        <input id="duration" class="form-control" name="duration"
                                                               type="number" min="0"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group mb-4">
                                                <div class="row">
                                                    <label class="col-md-4">Đạo diễn :</label>
                                                    <div class="col-md-8">
                                                        <input id="manager" class="form-control" name="manager"
                                                               type="text"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group mb-4">
                                                <div class="row">
                                                    <label class="col-md-4">Diễn viên :</label>
                                                    <div class="col-md-8">
                                                        <input id="actor" class="form-control" name="actor"
                                                               type="text"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group mb-4">
                                                <div class="row">
                                                    <label class="col-md-4">Khuyến cáo :</label>
                                                    <div class="col-md-8">
                                                        <input id="recommend" class="form-control" name="recommend"
                                                               type="text"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group mb-4">
                                                <div class="row">
                                                    <label class="col-md-4" for="premiere">Ngày công chiếu:</label>
                                                    <input class="col-md-8" type="date" id="premiere" name="premiere"
                                                           value="2024-07-22" min="2024-01-01" max="2024-12-31"/>
                                                </div>
                                            </div>
                                            <div class="align-center btn-success align-item-center">
                                                <input id="submit" value="Submit" class="btn mt-5 mb-4 bg-primary" type="submit"/>
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


<%--    toast--%>
    <div class="toast-container position-fixed bottom-0 end-0 p-3">
        <div
                id="liveToast"
                class="toast"
                role="alert"
                aria-live="assertive"
                aria-atomic="true"
        >
            <div class="toast-header">
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="toast"
                        aria-label="Close"
                ></button>
            </div>
            <div class="toast-body bg-primary text-center fs-1">Success</div>
        </div>
    </div>

</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="https://upload-widget.cloudinary.com/latest/global/all.js" type="text/javascript"></script>

<script type="text/javascript">
    // Khai báo biến myWidget ở ngoài để có thể sử dụng và lắng nghe sự kiện submit của form
    var myWidget;

    document.addEventListener("DOMContentLoaded", function () {
        myWidget = cloudinary.createUploadWidget({
                cloudName: 'dpgnm1bdi',
                uploadPreset: 'dmdmdm'
            }, (error, result) => {
                if (!error && result && result.event === "success") {
                    console.log('Done! Here is the image info: ', result.info);
                    document.querySelector("#img_url").value = result.info.url; // Sử dụng .value thay vì .textContent
                }
            }
        );

        // Lắng nghe sự kiện click trên nút upload_widget
        document.getElementById("upload_widget").addEventListener(
            "click",
            function (event) {
                event.preventDefault(); // Ngăn chặn hành vi mặc định của nút upload
                myWidget.open(); // Mở widget upload khi click vào nút upload_widget
            },
            false
        );

        document.querySelector("form").addEventListener("submit", function (event) {
        });
    });


    const toastTrigger = document.getElementById("submit");
    const toastLiveExample = document.getElementById("liveToast");

    if (toastTrigger) {
        const toastBootstrap =
            bootstrap.Toast.getOrCreateInstance(toastLiveExample);
        toastTrigger.addEventListener("click", () => {
            toastBootstrap.show();
        });
    }
</script>

</html>
