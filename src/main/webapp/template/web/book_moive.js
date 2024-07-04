const enable__shtime = document.querySelectorAll('.shtime__item');
const btn__noti = document.querySelector('.noti__btn');
const popup = document.querySelector('#popup__wrapper')

enable__shtime.forEach(item => {

    item.addEventListener("click", () => {
        enable__shtime.forEach(element => {
            if (element.classList.contains('enable')) {
                element.classList.remove('enable');
            }
        });
        item.classList.toggle('enable');
    });
});

//

const minus_f = document.querySelector('.minus_f');
const minus_s = document.querySelector('.minus_s');
const minus_t = document.querySelector('.minus_t');
const count_f = document.querySelector('.count_f');
const count_s = document.querySelector('.count_s');
const count_t = document.querySelector('.count_t');
const plus_f = document.querySelector('.plus_f');
const plus_s = document.querySelector('.plus_s');
const plus_t = document.querySelector('.plus_t');


let cf = 0;
let ct = 0;
let cs = 0;
minus_f.addEventListener("click", () => {
    let isCount = parseInt(count_f.textContent)
    if (isCount >= 1) {
        isCount--; // Tăng giá trị của cf lên 1
        count_f.innerHTML = isCount; // Gán giá trị mới của cf vào textContent của count_f
    }
});
minus_s.addEventListener("click", () => {
    let isCount = parseInt(count_s.textContent)
    if (isCount >= 1) {
        isCount--; // Tăng giá trị của cf lên 1
        count_s.innerHTML = isCount; // Gán giá trị mới của cf vào textContent của count_f
    }
}); minus_t.addEventListener("click", () => {
    let isCount = parseInt(count_t.textContent)
    if (isCount >= 1) {
        isCount--; // Tăng giá trị của cf lên 1
        count_t.innerHTML = isCount; // Gán giá trị mới của cf vào textContent của count_f
    }
});


plus_f.addEventListener('click', () => {
    let isCount = parseInt(count_f.textContent)
    if (isCount <= 7) {
        isCount++; // Tăng giá trị của cf lên 1
        count_f.innerHTML = isCount; // Gán giá trị mới của cf vào textContent của count_f
    }
})


plus_s.addEventListener('click', () => {
    let isCount = parseInt(count_s.textContent)
    if (isCount <= 7) {
        isCount++; // Tăng giá trị của cf lên 1
        count_s.innerHTML = isCount; // Gán giá trị mới của cf vào textContent của count_f
    }
})




plus_t.addEventListener('click', () => {
    let isCount = parseInt(count_t.textContent)
    if (isCount <= 7) {
        isCount++; // Tăng giá trị của cf lên 1
        count_t.innerHTML = isCount; // Gán giá trị mới của cf vào textContent của count_f
    }
})



let count;
const btn_plus = document.querySelectorAll('.count :nth-child(3)');
count = parseInt(count_f.textContent) + parseInt(count_s.textContent) + parseInt(count_t.textContent);
if (count <= 7) {
    btn_plus.forEach(element => {
        element.addEventListener("click", () => {
            count = parseInt(count_f.textContent) + parseInt(count_s.textContent) + parseInt(count_t.textContent);
            if (count > 8) {
                popup.classList.add('dp-block');
            }
        })
    })
};

// seat table
const seat_table = document.querySelectorAll('.seat__single');

seat_table.forEach(element => {
    element.addEventListener("click", () => {
        element.classList.toggle("is__selected");//them/xoa class vao element
        img = element.children[0];//lay ra phan tu con dau tien cua element
        if (element.classList.contains('is__selected')) {
            img.src = '../../template/assets/images/seat-single-selecting.svg';
        } else {
            img.src = '../../template/assets/images/seat-single.svg';
        }
        seat = element.children[1];
        console.log(seat.innerText)
    })
});



btn__noti.addEventListener("click", () => {
    popup.classList.remove('dp-block')
    popup.classList.add('dp-none')
})

console.log(popup)