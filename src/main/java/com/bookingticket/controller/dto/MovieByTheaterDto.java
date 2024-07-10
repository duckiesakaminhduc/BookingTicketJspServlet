package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.sql.Timestamp;

public class MovieByTheaterDto {


    @ColumnName("id")
    private Long movie_id;
    @ColumnName("movie_name")
    private String movie_name;
    @ColumnName("create_at")
    private Timestamp create_at;
    @ColumnName("create_by")
    private String create_by;
    @ColumnName("modified_at")
    private Timestamp modified_at;
    @ColumnName("modified_by")
    private String modified_by;
    @ColumnName("url_img")
    private String url_img;
    @ColumnName("status")
    private int status;

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

    @Override
    public String toString() {
        return "MovieByTheaterDto{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", create_at=" + create_at +
                ", create_by='" + create_by + '\'' +
                ", modified_at=" + modified_at +
                ", modified_by='" + modified_by + '\'' +
                ", url_img='" + url_img + '\'' +
                ", status=" + status +
                '}';
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
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

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public MovieByTheaterDto(Long movie_id, String movie_name, Timestamp create_at, String create_by, Timestamp modified_at, String modified_by, String url_img, int status) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.create_at = create_at;
        this.create_by = create_by;
        this.modified_at = modified_at;
        this.modified_by = modified_by;
        this.url_img = url_img;
        this.status = status;
    }

    public MovieByTheaterDto() {
    }
}
