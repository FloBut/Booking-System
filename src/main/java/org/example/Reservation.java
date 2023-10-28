package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

//O rezervare poate fi facuta pentru o camera, de catre un client, intre doua date (check in si check out).
public class Reservation {
    private Room reservedRoomNo;
    private UserClient userClient;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Room reservedRoomNo,LocalDate checkIn, LocalDate checkOut) {
        this.reservedRoomNo = reservedRoomNo;
        this.userClient = userClient;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    public Room getReservedRoomNo() {
        return reservedRoomNo;
    }

    public void setReservedNo(Room reservedNo) {
        this.reservedRoomNo = reservedRoomNo;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    public void setUserClient(UserClient userClient) {
        this.userClient = userClient;
    }


    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservedRoomNo=" + reservedRoomNo +
                ", userClient=" + userClient +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
