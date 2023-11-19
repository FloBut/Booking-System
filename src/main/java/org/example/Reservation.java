package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

//O rezervare poate fi facuta pentru o camera, de catre un client, intre doua date (check in si check out).
public class Reservation {
    private Integer reservedRoomNo;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Integer reservedRoomNo,LocalDate checkIn, LocalDate checkOut) {
        this.reservedRoomNo = reservedRoomNo;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    public Integer getReservedRoomNo() {
        return reservedRoomNo;
    }

    public void setReservedNo(Integer reservedNo) {
        this.reservedRoomNo = reservedRoomNo;
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
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
