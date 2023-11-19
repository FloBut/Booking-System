package org.example;

import java.util.ArrayList;
import java.util.List;

//hotelul are un nume si o lista de camere

public class Hotel {
    private String hotelName;
    List<Room> rooms;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    //metoda va returna o camera dupa numarul camerei
    public Room getRoomFromHotelByNumber(int roomNumber) throws Exception {
        for (Room room : getRooms()) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        throw  new Exception("not found");
    }

    //aceeasi metoda folosind expresii lamba

    public Room findRoomByNumber (Integer roomNumber) throws Exception {
       return  rooms.stream()
                .filter(r -> r.getRoomNumber().equals(roomNumber))
                .findFirst()
               .orElseThrow(() -> new Exception("room not found"));
    }


}
