package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class ScreeningByMovieDto {
    @ColumnName("day")
    private String day;
    @ColumnName("day_of_week")
    private String day_of_week;

    public ScreeningByMovieDto() {
    }

    public ScreeningByMovieDto(String day, String day_of_week) {

        this.day = day;
        this.day_of_week = day_of_week;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    @Override
    public String toString() {
        return "ScreeningByMovieDto{" +
                ", day='" + day + '\'' +
                ", day_of_week='" + day_of_week + '\'' +
                '}';
    }
}
