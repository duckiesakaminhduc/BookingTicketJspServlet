const seat_table = document.querySelectorAll('.seat__single');
let seat_selected = [];

seat_table.forEach(element => {
    element.addEventListener("click", () => {
        element.classList.toggle("is__selected");//them/xoa class vao element
        img = element.children[0];//lay ra phan tu con dau tien cua element
        let span = element.getElementsByClassName('seate__single__name')[0];
        if (element.classList.contains('is__selected')) {
            img.src = '../../template/assets/images/seat-single-selecting.svg';
            seat_selected.push(span.innerText)
        } else {
            img.src = '../../template/assets/images/seat-single.svg';
            seat_selected = seat_selected.filter(item => !(item == span.innerText))
        }
        seat = element.children[1];
        //
        //
        // in ra danh sach ghe
        // console.log(seat_selected)
        let movie_info = document.querySelector(".movie-info");
        let seat_info = movie_info.querySelector(".seat_info");
        // let seat_info = document.querySelector(".seat_info");
        let seats = "";
        seat_selected.forEach(item => {
            seats += item + " "
            seat_info.innerHTML = "GHẾ: " + seats;
        })
        // console.log(seats)

    })
});


$(document).ready(function () {

    $('.schedule_btn').click(function () {
        let day = $(this).find('.date-time').text();
        let movie_id = $("#movie_id").text();

        $.ajax({
            url: `http://localhost:8080/BookingTicket/movie/schedule`,
            type: "GET",
            data: {
                "movie_id": movie_id,
                "day": day
            },
            success: function (data) {
                // console.log(data)
                let ul_root = document.querySelector("#list_schedule");
                ul_root.innerHTML = ''; // Clear existing content

                data.forEach(item => {
                    let arr_name = Object.keys(item);
                    // ['CINESTAR HUẾ', 'CINESTAR HAI BÀ TRƯNG', 'CINESTAR SINH VIÊN']
                    let arr_time = Object.values(item)

                    if (arr_name.length == 0) {
                        ul_root.innerHTML = '<h1 class="text-center mt-3">CHƯA CÓ LỊCH CHIẾU</h1>'
                    } else {
                        arr_name.forEach(name => {
                            let arr_time = item[name];


                            let li_root = document.createElement('li');
                            li_root.className = 'item__cinestar';

                            let div_title__cinestar = document.createElement('div');
                            div_title__cinestar.className = 'title__cinestar';
                            div_title__cinestar.style.paddingTop = '10px';

                            let id_class = generateUUID();

                            let input = document.createElement('input');
                            input.type = 'radio';
                            input.name = 'cinestar__checked';
                            input.id = id_class;

                            let label = document.createElement('label');
                            label.setAttribute('for', id_class);

                            let h2 = document.createElement('h2');
                            h2.textContent = name;
                            label.appendChild(h2);

                            let div_collapse__shtime = document.createElement('div');
                            div_collapse__shtime.className = 'collapse__shtime';

                            let ul_child = document.createElement('ul');
                            ul_child.className = 'list__shtime';
                            ul_child.setAttribute("style", "justify-content: flex-start;gap:10px")
                            arr_time.forEach(time => {
                                let li_child = document.createElement("li");
                                li_child.className = "shtime__item";
                                li_child.textContent = time.time;
                                li_child.setAttribute("screening_id", time.screening_id);
                                ul_child.appendChild(li_child);
                            });

                            div_collapse__shtime.appendChild(ul_child);
                            div_title__cinestar.appendChild(input);
                            div_title__cinestar.appendChild(label);
                            div_title__cinestar.appendChild(div_collapse__shtime);
                            li_root.appendChild(div_title__cinestar);
                            ul_root.appendChild(li_root);
                        })
                    }
                });


                let shtime__item = document.querySelectorAll(".shtime__item");
                shtime__item.forEach(item => item.addEventListener('click', (e) => {
                    document.querySelector("#nav_bottom").style.display = "block"
                    let screening_id = e.target.getAttribute("screening_id");
                    // console.log(screening_id)
                    $.ajax({
                        url: `http://localhost:8080/BookingTicket/room/screening_id`,
                        type: "GET",
                        data: {
                            "screening_id": screening_id
                        },
                        success: function (data) {
                            let room_id = data.id;
                            $.ajax({
                                url: `http://localhost:8080/BookingTicket/getSeats`,
                                type: "GET",
                                data: {
                                    "screening_id": screening_id,
                                    "room_id": room_id,
                                },
                                success: function (data) {

                                    let obj_root = Object.values(data)
                                    let arr_seat_name_is_selected = obj_root[0].map(item => item.seat_name);

                                    let seat_single_list = document.querySelectorAll(".seat__single")
                                    seat_single_list.forEach(item => {
                                        let seat_name = item.innerText;
                                        if (arr_seat_name_is_selected.includes(seat_name)) {
                                            item.setAttribute("style", "pointer-events: none;")
                                            console.log(seat_name);
                                            let img = item.querySelector("img");
                                            img.setAttribute("src", "../../template/assets/images/seat-single-disable.svg")
                                        }
                                    })

                                }
                            })
                        }
                    })


                }));
            }
        });
    });
});


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

$(document).ready(function () {
    // combo price
    let total_root = document.querySelector(".total");
    let total_price = 0;

    // ticket
    let ticket__item = document.querySelectorAll('.ticket__item');
    ticket__item.forEach(item => {
        item.addEventListener('click', (e) => {
            let value_ticket = item.querySelector(".value_ticket");
            let amount_ticket = item.querySelector('.amount_ticket ');
            let total = parseInt(value_ticket.innerText) * 1000 * parseInt(amount_ticket.innerText)
            total_price += total;

            total_root.innerHTML = total_price + " VND"
        })
    })


    let combo_item = document.querySelectorAll(".combo-item");
    combo_item.forEach(item => {

        item.addEventListener('click', (e) => {
            let value = item.querySelector(".value");
            let span = item.querySelector("span");
            let total = parseInt(value.innerText) * parseInt(span.innerText);
            total_price += total * 1000;
            total_root.innerHTML = total_price + " VND"
        })
    })
})

// $(document).ready(function () {
//     let btn_order_submit = document.querySelector(".btn_order_submit");
//     btn_order_submit.addEventListener('click', (e) => {
//         let header = document.querySelector(".header");
//         let movie_info = header.querySelector(".movie-info");
//         let movie_name = movie_info.querySelector("h1").textContent;
//         let seats = movie_info.querySelector(".seat_info").textContent;
//         let description = "ĐẶT PHIM: " + movie_name + "|" + seats;
//         let amount = header.querySelector(".total").textContent;
//         $.ajax({
//             url: `http://localhost:8080/BookingTicket/create_ticket`,
//             type: "POST",
//             data: {
//                 "amount": amount,
//                 "app_user": "user_name",
//                 "description": description
//             },
//             success: function (data) {
//                 let order_url = data.order_url;
//                 window.location.href = order_url;
//             }
//
//         })
//     })
// })
$(document).ready(function () {
    let btn_order_submit = document.querySelector(".btn_order_submit");
    btn_order_submit.addEventListener('click', (e) => {
        let header = document.querySelector(".header");
        let movie_info = header.querySelector(".movie-info");
        let movie_name = movie_info.querySelector("h1").textContent;
        let seats = movie_info.querySelector(".seat_info").textContent;
        let description = "ĐẶT PHIM: " + movie_name + "|" + seats;
        let amount = parseInt(header.querySelector(".total").textContent);
        console.log(description, amount)
        $.ajax({
            url: `http://localhost:8080/BookingTicket/create_ticket`,
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: {
                "amount": amount,
                "app_user": "user_name",
                "description": description
            },
            success: function (data) {
                let order_url = data.order_url;
                window.location.href = order_url;
            }

        })
    })
})