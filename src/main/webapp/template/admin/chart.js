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
            // Sử dụng forEach để lặp qua từng đối tượng trong mảng JSON
            data.forEach(item => {
                labels.push(item.theater_name);  // Lấy theater_name từ mỗi đối tượng
                datas.push(item.total_price);    // Lấy total_price từ mỗi đối tượng
            });

            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Revenue by Theater',
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
