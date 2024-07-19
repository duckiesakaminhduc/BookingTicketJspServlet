<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
</head>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #1a2238;
        color: white;
        margin: 0;
    }

    .menu-container {
        max-width: 1200px;
        margin: 0 auto;
        padding: 3px;
        margin-bottom: 150px;
    }

    h1 {
        text-align: center;
        font-size: 2.5em;
        margin-bottom: 30px;
    }

    h2 {
        color: #ffd700;
        font-size: 1.8em;
        margin-top: 40px;
    }

    .combo-row {
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
        gap: 20px;
    }

    .combo-item {
        background-color: #2a3350;
        border-radius: 10px;
        padding: 20px;
        width: calc(33.33% - 20px);
        box-sizing: border-box;
        text-align: center;
    }

    .combo-item img {
        width: 100%;
        height: auto;
        border-radius: 5px;
        margin-bottom: 15px;
    }

    .combo-item h3 {
        font-size: 1.2em;
        margin: 10px 0;
        background-color: #2a3350;
    }

    .combo-item p {
        margin: 5px 0;
        background-color: #2a3350;
    }

    .quantity-selector {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 15px;
        background-color: #2a3350;
    }

    .quantity-selector button {
        background-color: #4a5580;
        border: none;
        color: white;
        font-size: 1.2em;
        width: 30px;
        height: 30px;
        border-radius: 50%;
        cursor: pointer;
    }

    .quantity-selector span {
        margin: 0 10px;
        font-size: 1.2em;
        background-color: #2a3350;
        background-color: #2a3350;
    }

    #totalPrice {
        text-align: right;
        font-size: 1.5em;
        margin-top: 30px;
        color: #ffd700;
    }

    @media (max-width: 768px) {
        .combo-item {
            width: calc(50% - 10px);
        }
    }

    @media (max-width: 480px) {
        .combo-item {
            width: 100%;
        }
    }

    /* CSS để làm nổi bật khi chọn */
    .combo-item.selected {
        border: 2px solid #ffd700; /* Màu vàng sáng cho khung chọn */
        background-color: #2a3350; /* Đảm bảo nền không bị thay đổi */
    }


</style>
<body>
<div class="menu-container">
    <h1>CHỌN BẮP NƯỚC</h1>

    <h2>COMBO</h2>
    <div class="combo-row">
        <div class="combo-item">
            <img src="https://api-website.cinestar.com.vn/media/.thumbswysiwyg/pictures/HinhQuayconnew/Combo-Solo.png?rand=1718957425"
                 alt="Combo Solo"/>
            <h3>COMBO SOLO</h3>
            <p>1 Bắp Ngọt 60oz + 1 Coke 32oz</p>
            <p class="value">94,000 VND đ</p>
            <div class="quantity-selector">
                <button>-</button>
                <span>0</span>
                <button>+</button>
            </div>
        </div>

        <div class="combo-item">
            <img src="https://api-website.cinestar.com.vn/media/.thumbswysiwyg/pictures/HinhQuayconnew/Combo-couple.png?rand=1718957425"
                 alt="Combo Couple"/>
            <h3>COMBO COUPLE</h3>
            <p>1 Bắp Ngọt 60oz + 2 Coke 32oz</p>
            <p class="value">115,000 VND đ</p>
            <div class="quantity-selector">
                <button>-</button>
                <span>0</span>
                <button>+</button>
            </div>
        </div>

        <div class="combo-item">
            <img src="https://api-website.cinestar.com.vn/media/.thumbswysiwyg/pictures/HinhQuayconnew/Combo-party.png?rand=1718957425"
                 alt="Combo Party"/>
            <h3>COMBO PARTY</h3>
            <p>2 Bắp Ngọt 60oz + 4 Coke 22oz</p>
            <p class="value">209,000 VND đ</p>
            <div class="quantity-selector">
                <button>-</button>
                <span>0</span>
                <button>+</button>
            </div>
        </div>
    </div>


</div>
</body>
<script>

    document.addEventListener("DOMContentLoaded", function () {
        const combos = document.querySelectorAll(".combo-item");
        let total = 0;

        combos.forEach((combo) => {
            const minusBtn = combo.querySelector("button:first-of-type");
            const plusBtn = combo.querySelector("button:last-of-type");
            const quantitySpan = combo.querySelector("span");
            const priceText = combo.querySelector("p:last-of-type").textContent;
            const price = parseInt(priceText.replace(/\D/g, ""));

            minusBtn.addEventListener("click", () => updateQuantity(-1));
            plusBtn.addEventListener("click", () => updateQuantity(1));

            combo.addEventListener("click", () => {
                // Xóa lớp 'selected' khỏi tất cả các combo-item
                combos.forEach(c => c.classList.remove("selected"));
                // Thêm lớp 'selected' vào combo-item được chọn
                combo.classList.add("selected");
            });

            function updateQuantity(change) {
                let quantity = parseInt(quantitySpan.textContent);
                quantity = Math.max(0, quantity + change);
                quantitySpan.textContent = quantity;
                updateTotal();
            }

            function updateTotal() {
                total = 0;
                combos.forEach((c) => {
                    const q = parseInt(c.querySelector("span").textContent);
                    const p = parseInt(
                        c.querySelector("p:last-of-type").textContent.replace(/\D/g, "")
                    );
                    total += q * p;
                });

            }
        });
    });


    <%--document.addEventListener("DOMContentLoaded", function () {--%>
    <%--    const combos = document.querySelectorAll(".combo-item");--%>
    <%--    let total = 0;--%>

    <%--    combos.forEach((combo) => {--%>
    <%--        const minusBtn = combo.querySelector("button:first-of-type");--%>
    <%--        const plusBtn = combo.querySelector("button:last-of-type");--%>
    <%--        const quantitySpan = combo.querySelector("span");--%>
    <%--        const priceText = combo.querySelector("p:last-of-type").textContent;--%>
    <%--        const price = parseInt(priceText.replace(/\D/g, ""));--%>

    <%--        minusBtn.addEventListener("click", () => updateQuantity(-1));--%>
    <%--        plusBtn.addEventListener("click", () => updateQuantity(1));--%>

    <%--        function updateQuantity(change) {--%>
    <%--            let quantity = parseInt(quantitySpan.textContent);--%>
    <%--            quantity = Math.max(0, quantity + change);--%>
    <%--            quantitySpan.textContent = quantity;--%>
    <%--            updateTotal();--%>
    <%--        }--%>

    <%--        &lt;%&ndash;function updateTotal() {&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    total = 0;&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    combos.forEach((c) => {&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        const q = parseInt(c.querySelector("span").textContent);&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        const p = parseInt(&ndash;%&gt;--%>
    <%--        &lt;%&ndash;            c.querySelector("p:last-of-type").textContent.replace(/\D/g, "")&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        );&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        total += q * p;&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    });&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    document.getElementById(&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        "totalPrice"&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    ).textContent = `Total: ${total.toLocaleString()} VND`;&ndash;%&gt;--%>
    <%--        &lt;%&ndash;}&ndash;%&gt;--%>
    <%--    });--%>
    <%--});--%>
</script>
</html>
