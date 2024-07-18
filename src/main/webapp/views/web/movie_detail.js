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

                    console.log(item)

                    arr_name.forEach(name => {
                        let arr_time = item[name];

                        console.log(arr_time)

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
                });
            }
        });
    });
});

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
        // seat = element.children[1];
        console.log(seat_selected)
    })
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