package org.example;

import java.util.List;
//clasa are o lista de hoteluri si o lista de utizatori
public class Booking {

    private List<Hotel> hotelList;
    private List<UserAdministrator> userList;

    public Booking() {
        this.hotelList = hotelList;
        this.userList = userList;
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
