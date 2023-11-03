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
    public Room getRoomFromHotelByNumber(int roomNumber) {
        for (Room room : getRooms()) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
    //metoda va returna indicele de camera pentru un numar de camera
    //la ce folosesc acest indice?

    public int getIndexOfRoomFromHotelBy(int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getRoomNumber() == roomNumber) {
                return i;
            }

        }
        return -1;
    }



//    public int getIndexOfRoomFromHotelBy(int roomNumber) {
//        for (int i = 0; i < rooms.size(); i++) {
//            if (getRooms().get(i).getRoomNumber() == roomNumber) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
