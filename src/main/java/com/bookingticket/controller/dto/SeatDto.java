package com.bookingticket.controller.dto;

public class SeatDto {
    private Long id;
    private String seat_name;
    private int state;
    private Long room_id;
    private Long screening_id;

    public SeatDto(Long id, String seat_name, int state, Long room_id, Long screening_id) {
        this.id = id;
        this.seat_name = seat_name;
        this.state = state;
        this.room_id = room_id;
        this.screening_id = screening_id;
    }

    @Override
    public String toString() {
        return "SeatDto{" +
                "id=" + id +
                ", seat_name='" + seat_name + '\'' +
                ", state=" + state +
                ", room_id=" + room_id +
                ", screening_id=" + screening_id +
                '}';
    }

    public SeatDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(Long screening_id) {
        this.screening_id = screening_id;
    }
}
