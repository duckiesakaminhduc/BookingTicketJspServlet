package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class ScheduleDto {
//    @ColumnName("day")
//    private String day;
    @ColumnName("theater_name")
    private String theater_name;
    @ColumnName("time")
    private String time;
    @ColumnName("screening_id")
    private Long screening_id;
    public ScheduleDto() {
    }

//    public String getDay() {
//        return day;
//    }
//
//    public void setDay(String day) {
//        this.day = day;
//    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ScheduleDto(String theater_name, String time, Long screening_id) {
        this.theater_name = theater_name;
        this.time = time;
        this.screening_id = screening_id;
    }

    public Long getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(Long screening_id) {
        this.screening_id = screening_id;
    }

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "theater_name='" + theater_name + '\'' +
                ", time='" + time + '\'' +
                ", screening_id=" + screening_id +
                '}';
    }
}
