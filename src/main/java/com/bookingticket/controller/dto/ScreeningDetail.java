package com.bookingticket.controller.dto;

public class ScreeningDetail {
    private Long screening_id;
    private String time;

    public ScreeningDetail(Long screening_id, String time) {
        this.screening_id = screening_id;
        this.time = time;
    }

    public Long getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(Long screening_id) {
        this.screening_id = screening_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ScreeningDto{" +
                "screening_id=" + screening_id +
                ", time='" + time + '\'' +
                '}';
    }
}
