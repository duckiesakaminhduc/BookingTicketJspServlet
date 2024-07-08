package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class RevenueByTheaterDto {
    private String theater_name;
    private float total_price;
    private int month;
    public RevenueByTheaterDto() {
    }

    @Override
    public String toString() {
        return "RevenueByTheaterDto{" +
                "theater_name='" + theater_name + '\'' +
                ", total_price=" + total_price +
                ", month=" + month +
                '}';
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public RevenueByTheaterDto(String theater_name, float total_price, int month) {
        this.theater_name = theater_name;
        this.total_price = total_price;
        this.month = month;
    }
}
