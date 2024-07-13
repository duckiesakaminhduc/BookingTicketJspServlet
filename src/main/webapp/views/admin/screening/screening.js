//load image
let list_id_root = [];
let isDataLoaded = false;

$(document).ready(function () {
    $.ajax({
        url: `admin/movie/status`,
        type: "GET",
        success: function (data) {
            // console.log(data);
            const list_movies = $('#list_movies');
            $.each(data, function (index, item) {
                list_id_root.push(item.id);
                const movie_item = `<div class="movie__item">
            <div
                    id=${item.id}
                    ondragstart="drag(event)"
                    draggable="true"
                    class="card"
                    style="width: 5rem; font-size: 0.8em;"
            >
                <img src="${item.url_img}" class="card-img-top img-fluid " alt=""/>
                <div class="card-body" style="padding: 0.5rem;">
                    <p class="duration card-text text-center" style="margin-bottom: 0;">Time: ${item.duration}'</p>
                </div>
            <input class="day" type="text" value="alo">
            <div class="td_id">td_id </div>
                   </div>
        </div>`;
                list_movies.append(movie_item);
            })
            isDataLoaded = true;
        },
        error: function (xhr, status, error) {
            console.error("Có lỗi xảy ra:", status, error);
        }

    });


    $('#btn_submit').click(function () {

    })

});


//

function containsNonNumeric(str) {
    return /\D/.test(str);
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    // console.log(ev.target.id);
    let td = document.getElementById(ev.target.id);
    let span = td.getElementsByTagName('span');
    // console.log(span)
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    const dragElement = document.getElementById(data);
    if (!containsNonNumeric(dragElement.id)) {
        const clone = dragElement.cloneNode(true);
        clone.id = generateUUIDwithRoot(dragElement.id);

        ev.target.appendChild(clone);
        clone.addEventListener("ondragstart", (ev) => {
            ev.dataTransfer.setData("text", ev.target.id);
        });
        clone.setAttribute("draggable", "true");
    } else {
        ev.target.appendChild(dragElement);
    }
    // ==========================================
    // kiem tra the td gan nhat voi id cha
    // console.log(ev.target);
    let target = ev.target;
    let target_index;
    let target_id = target.id;
    let list_td = document.getElementsByTagName("td");

    for (let i = 0; i < list_td.length; i++) {
        if (list_td[i].id == target_id) {
            target_index = i;
            let td_target = document.getElementById(target_id);
            let day_id = i % 7;
            let day = td_target.querySelector('input')
            let td_span = td_target.getElementsByClassName('td_id')[0];
            td_span.textContent = i;
            day.value = day_id;
        }
        let td_cur = list_td[i];
        let span_time_child = td_cur.querySelector('span');
        let img = td_cur.querySelector('img');
        if (span_time_child.innerText !== "08:00" && img == null) {
            span_time_child.innerText = "Time"
        }
    }


    if (target_index > 6) {
        let target_pre = target_index - 7;


        let td_pre = list_td[target_pre];
        let time_child = td_pre.querySelector('span');
        let duration_p = target.querySelector('p').innerText;
        let duration = parseInt(duration_p.split(": ")[1].replaceAll("'", ''));
        let time_parent = target.querySelector('span');
        let sub = 15;

        let startTime = moment(time_child.innerText, 'HH:mm');

        let endTime = startTime.add(duration + sub, 'minutes').format("HH:mm");
        time_parent.innerText = endTime;
        // console.log(endTime)

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


// ==================================================================================================================
// ==================================================================================================================
// ==================================================================================================================
const plus = document.querySelector(".plus");

plus.addEventListener("click", (e) => {
    let scheduleBody = document.querySelector("#scheduleBody");
    let tr = document.createElement("tr");

    for (let i = 0; i < 7; i++) {
        let td = document.createElement("td");
        let div = document.createElement("div");
        let span = document.createElement("span");

        span.setAttribute("class", generateUUID());
        span.textContent = "Time";
        div.setAttribute("class", "border margin-10px-bottom font-size14");
        div.setAttribute(
            "style",
            `bottom: -27px;width: 100%;left: 0px;`
        );
        div.appendChild(span);

        td.setAttribute("style", "position: relative");
        td.setAttribute("id", generateUUID());

        //set drag
        td.setAttribute("ondrop", "drop(event)");
        //set drop
        td.setAttribute("ondragover", "allowDrop(event)");
        td.appendChild(div);
        tr.setAttribute(
            "style",
            `height: 90px; width: 90px; position: relative;margin-bottom: 50px`
        );
        tr.appendChild(td);
    }
    scheduleBody.appendChild(tr);

    //
});

function generateUUIDwithRoot(rootId) {
    return rootId + "-xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function (c) {
        var r = (Math.random() * 16) | 0,
            v = c == "x" ? r : (r & 0x3) | 0x8;
        return v.toString(16);
    });
}

//
// mobiscroll.setOptions({
//     theme: 'ios',
//     themeVariant: 'light'
// });
//
// mobiscroll.select('#select', {
//     inputElement: document.getElementById('input'),
// });

//
// const list = document.querySelector('#input');
// list.addEventListener('change', (e) => {
//     console.log(list.value)
// })

// ====================================================================================================


// ====================================================================================================
// ==========================================LAY RA TOAN BO LICH CHIEU DA SAP XEP==========================================================


$(document).ready(function () {
    $('#btn_submit').click(function () {
        let screenings = [];
        var table = document.querySelector('.table');
        var th_list = table.getElementsByTagName('th');
        var td_list = document.getElementsByTagName('td')
        // console.log(td_list)
        for (let i = 0; i < td_list.length; i++) {
            let td_item = td_list[i];
            let time_value = td_item.querySelector('span').innerText;
            let cards = td_item.getElementsByClassName('card');
            if (cards.length > 0) {
                let card = cards[0];
                let screening = {};
                let movie_id = card.id.split('-')[0];
                let day_input = card.getElementsByTagName('input');
                let day_id = day_input[0].value;
                let div_sibling = card.previousElementSibling;
                let span_time = div_sibling.getElementsByTagName('span')[0].innerText;
                let tr_root = document.querySelector('#tr');
                let th = tr_root.getElementsByTagName('th');
                let td_id = card.getElementsByClassName("td_id")[0]

                console.log(div_sibling)

                screening.movie_id = movie_id;
                screening.start_at = span_time;
                screening.day = th[day_id].innerText;
                screening.td_id = td_id.textContent;
                screenings.push(screening);
            }
        }
        console.log(screenings)
        $.ajax({
            url: "admin/screening",
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({
                "screenings": screenings
            }),
            success: function (data) {
                console.log('thanh cong');
            }
        })
    })
})


//load ngay
$(document).ready(function () {
    $.ajax({
        url: `admin/week`,
        type: "GET",
        success: function (data) {
            let tr = document.getElementById("tr");
            data.forEach(item => {
                let th = document.createElement('th');
                th.innerHTML = `<th class="text-uppercase">${item}</th>`;
                tr.appendChild(th)
            })
        }
    })
})

// load lich phim
function removeRows() {
    var tableBody = document.getElementById('scheduleBody');
    while (tableBody.rows.length > 1) {
        tableBody.deleteRow(1);
    }
}

$(document).ready(function () {
    $('#btn_filter').click(function () {
        var theater_id = Number($("#theater").val());
        var room_id = Number($("#room").val()) + 4 * (theater_id - 1);

        removeRows();

        $.ajax({
            url: `admin/getScreening`,
            type: "POST",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                "theater_id": theater_id,
                "room_id": room_id
            }),
            dataType: "json",
            success: function (data) {
                console.log(data)
                const maxTdId = Math.max(...data.map(item => parseInt(item.td_id)));
                const td_item_id = data.map(item => parseInt(item.td_id))
                let limit = maxTdId % 7;
                let scheduleBody = document.querySelector("#scheduleBody");

                for (let i = 0; i < limit; i++) {

                }

                // them cac dong td
                for (let k = 0; k <= limit; k++) {
                    let tr = document.createElement("tr");
                    for (let i = 0; i < 7; i++) {
                        let td = document.createElement("td");
                        let div = document.createElement("div");
                        let span = document.createElement("span");

                        span.setAttribute("class", generateUUID());
                        span.textContent = "Time";
                        div.setAttribute("class", "border margin-10px-bottom font-size14");
                        div.setAttribute(
                            "style",
                            `bottom: -27px;width: 100%;left: 0px;`
                        );
                        div.appendChild(span);

                        td.setAttribute("style", "position: relative");
                        td.setAttribute("id", generateUUID());

                        //set drag
                        td.setAttribute("ondrop", "drop(event)");
                        //set drop
                        td.setAttribute("ondragover", "allowDrop(event)");
                        td.appendChild(div);
                        tr.setAttribute(
                            "style",
                            `height: 90px; width: 90px; position: relative;margin-bottom: 50px`
                        );


                        tr.appendChild(td);
                    }
                    scheduleBody.appendChild(tr);
                }

                let td = document.getElementsByTagName('td');

                for (let i = 0; i < td_item_id.length; i++) {
                    cur = td_item_id[i];
                    let td_cur = td[cur];
                    let img_container = document.createElement('div');
                    let data_item = data.filter(item => item.td_id == cur)[0]
                    let col = Math.floor(data_item.td_id / 7);
                    let time = data_item.start_at.replace("-", ":");
                    // console.log(data_item)
                    let span = td_cur.querySelector('span');
                    span.innerText = time;
                    img_container.innerHTML = `
                      <div id="${generateUUIDwithRoot(data_item.movie_id)}" ondragstart="drag(event)" draggable="true" class="card" style="width: 5rem; font-size: 0.8em;">
        <img src="${data_item.url_img}" class="card-img-top img-fluid " alt="">
        <div class="card-body" style="padding: 0.5rem;">
            <p class="duration card-text text-center" style="margin-bottom: 0;">Time: ${data_item.duration}'</p>
        </div>
        <input class="day" type="text" value="${col}">
        <div class="td_id">${data_item.td_id}</div>
    </div>`;
                    td_cur.appendChild(img_container);
                }

            }
        })
    })


})