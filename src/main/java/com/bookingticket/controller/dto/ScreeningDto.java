package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScreeningDto {
    @ColumnName("id")
    private Long id;
    @ColumnName("day")
    private LocalDateTime day;
    @ColumnName("start_at")
    private LocalTime start_at;
    @ColumnName("movie_id")
    private Long movie_id;

    @ColumnName("td_id")
    private int td_id;

    public ScreeningDto() {
    }

    public ScreeningDto(Long id, LocalDateTime day, LocalTime start_at, Long movie_id, int td_id) {
        this.id = id;
        this.day = day;
        this.start_at = start_at;
        this.movie_id = movie_id;
        this.td_id = td_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public LocalTime getStart_at() {
        return start_at;
    }

    public void setStart_at(LocalTime start_at) {
        this.start_at = start_at;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public int getTd_id() {
        return td_id;
    }

    public void setTd_id(int td_id) {
        this.td_id = td_id;
    }
}
