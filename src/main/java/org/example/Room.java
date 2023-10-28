package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//O camera are numar, pret pe noapte, numar de persoane care pot fi cazate si o lista de rezervari
public class Room  {
    Integer roomNumber;
    Double pricePerRoom;
    Integer noPersonByRoom;
    List<Reservation> reservation;
    Availability availability;

    public Room(Integer roomNumber, Double pricePerRoom, Integer noPersonByRoom, Availability availability) {
        this.roomNumber = roomNumber;
        this.pricePerRoom = pricePerRoom;
        this.noPersonByRoom = noPersonByRoom;
        this.reservation = new ArrayList<>();
        this.availability = availability;
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

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {

        this.reservation = reservation;
    }

    // pe o camera vreau sa adaug o lista de rezervari cu ajutorul unei metode



    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", pricePerRoom=" + pricePerRoom +
                ", noPersonByRoom=" + noPersonByRoom +
                ", reservation=" + reservation +
                ", availability=" + availability +
                '}';
    }
}
