package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//O camera are numar, pret pe noapte, numar de persoane care pot fi cazate si o lista de rezervari
public class Room implements Comparable<Room> {
    private Integer roomNumber;
    private Integer pricePerRoom;
    private Integer noPersonByRoom;
    private List<Reservation> reservationList = new ArrayList<>();

    public Room(Integer roomNumber, Integer pricePerRoom, Integer noPersonByRoom) {
        this.roomNumber = roomNumber;
        this.pricePerRoom = pricePerRoom;
        this.noPersonByRoom = noPersonByRoom;
        this.reservationList = new ArrayList<>();
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPricePerRoom() {
        return pricePerRoom;
    }

    public void setPricePerRoom(Integer pricePerRoom) {
        this.pricePerRoom = pricePerRoom;
    }

    public Integer getNoPersonByRoom() {
        return noPersonByRoom;
    }

    public void setNoPersonByRoom(Integer noPersonByRoom) {
        this.noPersonByRoom = noPersonByRoom;
    }



    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }



    // metoda imi va returna o lista de rezervari doar daca datele sunt disponibile

    public boolean isReservedRoomBetween(LocalDate checkIn, LocalDate checkOut) {
        return reservationList.stream().
                anyMatch(reservation -> reservation.getCheckOut().isAfter(checkIn) && reservation.getCheckIn().isBefore(checkOut));
    }



// compar pretul unei camere cu pretul altei camere si voi returna camera cu pretul cel mai mic



    @Override
    public int compareTo(Room anotherRoom) {
        return Integer.compare(pricePerRoom, anotherRoom.getPricePerRoom());
    }



    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", pricePerRoom=" + pricePerRoom +
                ", noPersonByRoom=" + noPersonByRoom +
                ", reservationList=" + reservationList +
                '}';
    }
}
