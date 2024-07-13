package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScreeningGetDto {
    @ColumnName("screening_id")
    private Long screening_id;
    @ColumnName(("movie_id"))
    private Long movie_id;
    @ColumnName("day")
    private String day;
    @ColumnName("start_at")
    private String start_at;
    @ColumnName("url_img")
    private String url_img;
    @ColumnName("duration")
    private int duration;

    @ColumnName("td_id")
    private int td_id;
    public ScreeningGetDto() {
    }

    public ScreeningGetDto(Long screening_id, Long movie_id, String day, String start_at, String url_img, int duration, int td_id) {
        this.screening_id = screening_id;
        this.movie_id = movie_id;
        this.day = day;
        this.start_at = start_at;
        this.url_img = url_img;
        this.duration = duration;
        this.td_id = td_id;
    }

    public Long getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(Long screening_id) {
        this.screening_id = screening_id;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTd_id() {
        return td_id;
    }

    public void setTd_id(int td_id) {
        this.td_id = td_id;
    }
}
