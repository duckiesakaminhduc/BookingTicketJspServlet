package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.sql.Timestamp;

public class MovieDto {
    @ColumnName("create_at")
    private Timestamp create_at;
    @ColumnName("create_by")
    private String create_by;
    @ColumnName("modified_at")
    private Timestamp modified_at;
    @ColumnName("modified_by")
    private String modified_by;
    @ColumnName("category")
    private String category;
    @ColumnName("country")
    private String country;
    @ColumnName("duration")
    private int duration;
    @ColumnName("format")
    private String format;
    @ColumnName("manager")
    private String manager;
    @ColumnName("movie_name")
    private String movie_name;
    @ColumnName("performers")
    private String performers;
    @ColumnName("premiere")
    private String premiere;
    @ColumnName("recommend")
    private String recommend;
    @ColumnName("subtitle")
    private String subtitle;
    @ColumnName("url_img")
    private String url_img;
    @ColumnName("status")
    private int status;

    public MovieDto() {
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }

    public void setModified_at(Timestamp modified_at) {
        this.modified_at = modified_at;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public MovieDto(Timestamp create_at, String create_by, Timestamp modified_at, String modified_by, String category, String country, int duration, String format, String manager, String movie_name, String performers, String premiere, String recommend, String subtitle, String url_img) {
        this.create_at = create_at;
        this.create_by = create_by;
        this.modified_at = modified_at;
        this.modified_by = modified_by;
        this.category = category;
        this.country = country;
        this.duration = duration;
        this.format = format;
        this.manager = manager;
        this.movie_name = movie_name;
        this.performers = performers;
        this.premiere = premiere;
        this.recommend = recommend;
        this.subtitle = subtitle;
        this.url_img = url_img;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "create_at=" + create_at +
                ", create_by='" + create_by + '\'' +
                ", modified_at=" + modified_at +
                ", modified_by='" + modified_by + '\'' +
                ", category='" + category + '\'' +
                ", country='" + country + '\'' +
                ", duration=" + duration +
                ", format='" + format + '\'' +
                ", manager='" + manager + '\'' +
                ", movie_name='" + movie_name + '\'' +
                ", performers='" + performers + '\'' +
                ", premiere='" + premiere + '\'' +
                ", recommend='" + recommend + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", url_img='" + url_img + '\'' +
                ", status=" + status +
                '}';
    }
}
