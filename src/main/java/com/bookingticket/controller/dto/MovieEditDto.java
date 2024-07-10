package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class MovieEditDto {
    @ColumnName("movie_name")
    private String movie_name;
    @ColumnName("status")
    private int status;
    @ColumnName("url_img")
    private String url_img;
    @ColumnName("country")
    private String country;
    @ColumnName("duration")
    private int duration;
    @ColumnName("manager")
    private String manager;
    @ColumnName("performers")
    private String performers;
    @ColumnName("subtitle")
    private String subtitle;
    @ColumnName("recommend")
    private String recommend;
    @ColumnName("premiere")
    private String premiere;


    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public MovieEditDto(String movie_name, int status, String url_img, String country, int duration, String manager, String performers, String subtitle, String recommend, String premiere) {
        this.movie_name = movie_name;
        this.status = status;
        this.url_img = url_img;
        this.country = country;
        this.duration = duration;
        this.manager = manager;
        this.performers = performers;
        this.subtitle = subtitle;
        this.recommend = recommend;
        this.premiere = premiere;
    }

    public MovieEditDto() {
    }

    @Override
    public String toString() {
        return "MovieEditDto{" +
                "movie_name='" + movie_name + '\'' +
                ", status=" + status +
                ", url_img='" + url_img + '\'' +
                ", country='" + country + '\'' +
                ", duration=" + duration +
                ", manager='" + manager + '\'' +
                ", performers='" + performers + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", recommend='" + recommend + '\'' +
                ", premiere='" + premiere + '\'' +
                '}';
    }
}
