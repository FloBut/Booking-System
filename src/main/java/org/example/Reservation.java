package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
//O rezervare poate fi facuta pentru o camera, de catre un client, intre doua date (check in si check out).
public class Reservation {
    private int reservationNo;
    private Room reservedNo;
    private UserClient user;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(int reservationNo, Room reservedNo, UserClient user, LocalDate checkIn, LocalDate checkOut) {
        this.reservationNo = reservationNo;
        this.reservedNo = reservedNo;
        this.user = user;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }



    public int getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(int reservationNo) {
        this.reservationNo = reservationNo;
    }

    public Room getReservedNo() {
        return reservedNo;
    }

    public void setReservedNo(Room reservedNo) {
        this.reservedNo = reservedNo;
    }

    public UserClient getUser() {
        return user;
    }

    public void setUser(UserClient user) {
        this.user = user;
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
}
