package com.bookingticket.controller.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TicketSingleton {
    private static TicketSingleton instance;

    private TicketSingleton() {
    }

    private Long id;
    private LocalDateTime create_at;
    private LocalDateTime modified_at;

    private String create_by;
    private String modified_by;


    private Long user_id;
    private Long room_id;
    private Long combo_id;
    private Long screening_id;
    private double total_price;
    private Long theater_id;

    private Long movie_id;

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public static TicketSingleton getInstance() {
        if (instance == null) {
            instance = new TicketSingleton();
        }
        return instance;
    }

    public static void setInstance(TicketSingleton instance) {
        TicketSingleton.instance = instance;
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

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
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

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Long getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(Long theater_id) {
        this.theater_id = theater_id;
    }

    public static void main(String[] args) {
        TicketSingleton t = TicketSingleton.getInstance();

    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    @Override
    public String toString() {
        return "TicketSingleton{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", modified_at=" + modified_at +
                ", create_by='" + create_by + '\'' +
                ", modified_by='" + modified_by + '\'' +
                ", user_id=" + user_id +
                ", room_id=" + room_id +
                ", combo_id=" + combo_id +
                ", screening_id=" + screening_id +
                ", total_price=" + total_price +
                ", theater_id=" + theater_id +
                ", movie_id=" + movie_id +
                '}';
    }
}
