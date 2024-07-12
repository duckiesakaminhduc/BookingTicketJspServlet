//load image
let list_id_root = [];
$(document).ready(function () {
    console.log("dang goi ajax")
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
                    style="width: 5rem"
            >
                <img src="${item.url_img}" class="card-img-top" alt=""/>
                <div class="card-body">
                    <p class="card-text">info</p>
                </div>
            </div>
        </div>`;
                list_movies.append(movie_item);
            })
        },
        error: function (xhr, status, error) {
            console.error("Có lỗi xảy ra:", status, error);
        }

    });
});


//


function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    const dragElement = document.getElementById(data);
    // if (dragElement.id == "drag1") {
    if (list_id_root.includes(dragElement.id)) {
        const clone = dragElement.cloneNode(true);
        clone.id = generateUUID();

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
        }
    }

    if (target_index > 6) {
        let target_pre = target_index - 7;
        let td_pre = list_td[target_pre];
        let time_child = td_pre.querySelector('span');
        console.log("target_pre", target_pre);
        console.log("td_pre", td_pre);
        console.log("time_child", time_child.innerText);

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
console.log("dang 2h30am");

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

function generateUUID() {
    return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function (c) {
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

console.log("list_id_root", list_id_root)

// ====================================================================================================
// ====================================================================================================
