package org.example;

import java.util.ArrayList;
import java.util.List;
//clasa are o lista de hoteluri si o lista de utizatori
public class Booking {

    private List<Hotel> hotelList;
    private List<UserAdministrator> userList;

    public Booking() {
        this.hotelList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public List<UserAdministrator> getUserList() {
        return userList;
    }

    public void setUserList(List<UserAdministrator> userList) {

        this.userList = userList;
    }
}
