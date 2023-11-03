package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//O camera are numar, pret pe noapte, numar de persoane care pot fi cazate si o lista de rezervari
public class Room implements Comparable<Room> {
    private int roomNumber;
    private int pricePerRoom;
    private int noPersonByRoom;
    private String hotelName = "";
    private List<Reservation> reservationList = new ArrayList<>();

    public Room(Integer roomNumber, int pricePerRoom, Integer noPersonByRoom) {
        this.roomNumber = roomNumber;
        this.pricePerRoom = pricePerRoom;
        this.noPersonByRoom = noPersonByRoom;
        this.reservationList = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPricePerRoom() {
        return pricePerRoom;
    }

    public void setPricePerRoom(int pricePerRoom) {
        this.pricePerRoom = pricePerRoom;
    }

    public int getNoPersonByRoom() {
        return noPersonByRoom;
    }

    public void setNoPersonByRoom(int noPersonByRoom) {
        this.noPersonByRoom = noPersonByRoom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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
