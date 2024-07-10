const plus = document.querySelector(".plus");
console.log(plus);

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
