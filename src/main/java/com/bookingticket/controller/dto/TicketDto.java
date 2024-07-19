package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.LocalDateTime;

public class TicketDto {
    @ColumnName("id")
    private Long id;
    @ColumnName("create_at")
    private LocalDateTime create_at;
    @ColumnName("modified_at")
    private LocalDateTime modified_at;
    @ColumnName("create_by")
    private String create_by;
    @ColumnName("modified_by")
    private String modified_by;
    @ColumnName("user_id")
    private Long user_id;
    @ColumnName("room_id")
    private Long room_id;
    @ColumnName("combo_id")
    private Long combo_id;
    @ColumnName("screening_id")
    private Long screening_id;
    @ColumnName("total_price")
    private float total_price;
    @ColumnName("theater_id")
    private Long theater_id;
    @ColumnName("movie_id")
    private Long movie_id;

    public TicketDto() {
    }

    public TicketDto(Long id, LocalDateTime create_at, LocalDateTime modified_at, String create_by, String modified_by, Long user_id, Long room_id, Long combo_id, Long screening_id, float total_price, Long theater_id, Long movie_id) {
        this.id = id;
        this.create_at = create_at;
        this.modified_at = modified_at;
        this.create_by = create_by;
        this.modified_by = modified_by;
        this.user_id = user_id;
        this.room_id = room_id;
        this.combo_id = combo_id;
        this.screening_id = screening_id;
        this.total_price = total_price;
        this.theater_id = theater_id;
        this.movie_id = movie_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getCombo_id() {
        return combo_id;
    }

    public void setCombo_id(Long combo_id) {
        this.combo_id = combo_id;
    }

    public Long getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(Long screening_id) {
        this.screening_id = screening_id;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public Long getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(Long theater_id) {
        this.theater_id = theater_id;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }
}
