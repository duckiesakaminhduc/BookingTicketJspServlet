$(document).ready(function () {
    console.log("Xxx")
    $.ajax({
        url: 'movie',
        type: "GET",
        success: function (data) {
            console.log(data);
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
                        <a href="#" class="card__button btn">Đặt vé</a>
                    </div>
                `;
                slide_root.appendChild(article);
            })
        },
        error: function (xhr, status, error) {
            console.error('Error fetching movie data:', status, error);
        }
    });
});