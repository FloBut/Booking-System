package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//O camera are numar, pret pe noapte, numar de persoane care pot fi cazate si o lista de rezervari
public class Room {
    Integer roomNumber;
    Double pricePerRoom;
    Integer noPersonByRoom;
    List<Date> reservation;

    public Room(Integer roomNumber, Double pricePerRoom, Integer noPersonByRoom) {
        this.roomNumber = roomNumber;
        this.pricePerRoom = pricePerRoom;
        this.noPersonByRoom = noPersonByRoom;
        this.reservation = new ArrayList<>();
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPricePerRoom() {
        return pricePerRoom;
    }

    public void setPricePerRoom(Double pricePerRoom) {
        this.pricePerRoom = pricePerRoom;
    }

    public Integer getNoPersonByRoom() {
        return noPersonByRoom;
    }

    public void setNoPersonByRoom(Integer noPersonByRoom) {
        this.noPersonByRoom = noPersonByRoom;
    }

    public List<Date> getReservation() {
        return reservation;
    }

    public void setReservation(List<Date> reservation) {
        this.reservation = reservation;
    }
}
