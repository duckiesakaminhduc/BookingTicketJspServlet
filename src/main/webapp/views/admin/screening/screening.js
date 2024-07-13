//load image
let list_id_root = [];
let isDataLoaded = false;
let initTableState = []; // declare globally
let afterChangeTable = []; // declare globally
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
            <input class="day" type="text" value="day_id">
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
        console.log("Bắt đầu quá trình submit");
        console.log("Số lượng td:", $('.table td').length);
        console.log("Nội dung của tr đầu tiên:", $('#tr').html());

        var theater_id = Number($("#theater").val());
        var room_id = Number($("#room").val()) + 4 * (theater_id - 1);

        let screenings = [];
        var table = document.querySelector('.table');
        if (!table) {
            console.error('Không tìm thấy bảng');
            return;
        }
        var th_list = table.getElementsByTagName('th');
        var td_list = table.getElementsByTagName('td');
        if (!td_list || td_list.length === 0) {
            console.error('Không tìm thấy phần tử td nào');
            return;
        }

        for (let i = 0; i < td_list.length; i++) {
            let td_item = td_list[i];
            let time_span = td_item.querySelector('span');
            if (!time_span) continue;

            let cards = td_item.getElementsByClassName('card');
            if (cards.length > 0) {
                let card = cards[0];
                let screening = {};
                let movie_id = card.id.split('-')[0];
                let day_input = card.querySelector('input');
                if (!day_input) continue;

                let day_id = day_input.value;
                let div_sibling = card.previousElementSibling;
                if (!div_sibling) continue;

                let span_time = div_sibling.querySelector('span');
                if (!span_time) continue;

                let tr_root = document.querySelector('#tr');
                if (!tr_root) continue;

                let th = tr_root.getElementsByTagName('th');
                if (!th || th.length <= day_id) continue;

                let td_id = card.querySelector(".td_id");
                if (!td_id) continue;

                screening.movie_id = movie_id;
                screening.start_at = span_time.innerText;
                screening.day = th[day_id].innerText;
                screening.td_id = td_id.textContent;
                screenings.push(screening);
            }
        }

        if (screenings.length === 0) {
            console.error('Không tìm thấy lịch chiếu nào');
            return;
        }

        console.log("Lịch chiếu sẽ được gửi:", screenings);
        $.ajax({
            url: "admin/screening",
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({
                "screenings": screenings,
                "room_id": room_id
            }),
            success: function (data) {
                console.log('Gửi lịch chiếu thành công');
            },
            error: function (xhr, status, error) {
                console.error("Lỗi khi gửi lịch chiếu:", error);
            }
        });
    });
});

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
});

function generateUUIDwithRoot(rootId) {
    return rootId + "-xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function (c) {
        var r = (Math.random() * 16) | 0,
            v = c == "x" ? r : (r & 0x3) | 0x8;
        return v.toString(16);
    });
}

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
        console.log(room_id);
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
                // console.log(data)
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

                // console.log("Cấu trúc bảng sau khi filter:");
                // console.log($('.table').html());

                setTimeout(function () {
                    $('#btn_submit').prop('disabled', false);
                }, 500);
                initTableState = saveInitialTableState();
                console.log(initTableState)
            }
        })


    })
})

function saveInitialTableState() {
    let initTableState = [];
    let table = document.querySelector("table");
    let td_list = table.getElementsByTagName("td");
    let th_list = table.getElementsByTagName("th");
    for (let i = 0; i < td_list.length; i++) {
        let td_item = td_list[i];
        let cards = td_item.getElementsByClassName("card");
        if (cards.length > 0) {
            let card = cards[0];

            let td_id_div = card.querySelector(".td_id")
            let day_id_div = card.querySelector(".day")
            let dayIndex = parseInt(day_id_div.value);
            let screening = {};

            screening.td_id = td_id_div.innerHTML;
            screening.card_id = card.getAttribute("id") || null;
            screening.day = th_list[dayIndex].innerText;
            screening.time = td_item.getElementsByTagName("span")[0].innerText;
            initTableState.push(screening);
        }
    }
    return initTableState;
    // console.log(initTableState) ;
}

function classifyChanges(oldArray, newArray) {
    let addedItems = [];
    let changedItems = [];

    // Map for quick access
    let oldMap = {};
    oldArray.forEach(item => {
        oldMap[item.td_id] = item;
    });

    // Check new array
    newArray.forEach(item => {
        if (!oldMap.hasOwnProperty(item.td_id)) {
            // New item
            addedItems.push(item);
        } else if (oldMap[item.td_id].card_id !== item.card_id ||
            oldMap[item.td_id].day !== item.day ||
            oldMap[item.td_id].time !== item.time) {
            // Changed item
            changedItems.push(item);
        }
    });

    return {
        addedItems: addedItems,
        changedItems: changedItems
    };
}

$(document).ready(function () {
    $("#change").click(function () {
        afterChangeTable = saveInitialTableState();
        console.log(afterChangeTable)
        console.log(classifyChanges(initTableState, afterChangeTable))
    })
})
