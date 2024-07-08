package com.bookingticket.controller.dto;

public class RevenueByMovieDto {
    private String movie_name;
    private float total_price;

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "RevenueByMovieDto{" +
                "movie_name='" + movie_name + '\'' +
                ", total_price=" + total_price +
                '}';
    }

    public RevenueByMovieDto() {
    }

    public RevenueByMovieDto(String movie_name, float total_price) {
        this.movie_name = movie_name;
        this.total_price = total_price;
    }
}
