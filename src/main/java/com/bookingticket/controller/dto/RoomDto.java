package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class RoomDto {
    @ColumnName("id")
    private Long id;
    @ColumnName("room_name")
    private String room_name;
    @ColumnName("theater_id")
    private Long theater_id;

    public RoomDto() {
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", room_name='" + room_name + '\'' +
                ", theater_id=" + theater_id +
                '}';
    }

    public RoomDto(Long id, String room_name, Long theater_id) {
        this.id = id;
        this.room_name = room_name;
        this.theater_id = theater_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Long getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(Long theater_id) {
        this.theater_id = theater_id;
    }
}
