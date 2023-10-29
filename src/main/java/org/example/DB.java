package org.example;

public class DB {
    public DB() {
    }

    public void createDataBase(Booking booking) {
        Hotel hotel1 = new Hotel("Continental");
        Hotel hotel2 = new Hotel("Grand");
        Hotel hotel3 = new Hotel("Litoral");

        Admin admin = (Admin) booking.getUserList().get(0);
        admin.addHotel(hotel1, booking);
        admin.addHotel(hotel2, booking);
        admin.addHotel(hotel3, booking);

        Room room1 = new Room(1, 250, 2);
        Room room2 = new Room(2, 150, 1);
        Room room3 = new Room(3, 300, 3);
        Room room4 = new Room(4, 250, 1);
        Room room5 = new Room(1, 450, 3);
        Room room6 = new Room(2, 150, 1);
        Room room7 = new Room(3, 250, 3);
        Room room8 = new Room(4, 350, 2);
        Room room9 = new Room(1, 250, 2);
        Room room10 = new Room(2, 350, 2);
        Room room11 = new Room(3, 370, 3);
        Room room12 = new Room(4, 230, 1);
        admin.addRoom(room1, hotel1);
        admin.addRoom(room2, hotel1);
        admin.addRoom(room3, hotel1);
        admin.addRoom(room4, hotel1);
        admin.addRoom(room5, hotel2);
        admin.addRoom(room6, hotel2);
        admin.addRoom(room7, hotel2);
        admin.addRoom(room8, hotel2);
        admin.addRoom(room9, hotel3);
        admin.addRoom(room10, hotel3);
        admin.addRoom(room11, hotel3);
        admin.addRoom(room12, hotel3);

        Reservation reservation1 = new Reservation(2, LocalDate.of(2022, 8, 20), LocalDate.of(2022, 8, 22));
        Reservation reservation2 = new Reservation(2, LocalDate.of(2022, 8, 28), LocalDate.of(2022, 8, 29));
        hotel1.getRoomList().get(1).getReservationList().add(reservation1);
        hotel1.getRoomList().get(1).getReservationList().add(reservation2);
}
