$(document).ready(function () {
    $.ajax({
        url: 'movie',
        type: "GET",
        success: function (data) {
            let slide_root = document.getElementsByClassName('swiper-wrapper')[0];
            data.forEach(item => {
                let article = document.createElement('article');
                article.classList.add('card__article', 'swiper-slide');
                article.innerHTML = `
                    <div class="card__image">
                        <span class="movie_id">${item.id}</span>
                        <img src="${item.url_img}" alt="image" class="card__img">
                    </div>
                    <div class="card__data">
                        <h3 class="card__name">${item.movie_name}</h3>
                        <a href="http://localhost:8080/BookingTicket//movie/detail?movie_id=${item.id}" class="card__button btn btn-success">Đặt vé</a>
                    </div>
                `;
                slide_root.appendChild(article);
            });

            // Thêm CSS vào thẻ <style> trong mã HTML
            let styleTag = document.createElement('style');
            styleTag.textContent = `
                .card__name {
                    margin-top:10px;
                    background-color: transparent;
                    color: #00000;
                    transition: color 0.3s ease;
                }
                
                .card__name:hover {
                    color: #ffc107; /* Màu vàng khi hover */
                }
            `;
            document.head.appendChild(styleTag);
        },
        error: function (xhr, status, error) {
            console.error('Error fetching movie data:', status, error);
        }
    });
});

