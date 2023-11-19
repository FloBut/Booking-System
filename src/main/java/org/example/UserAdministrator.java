package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

////Administratorii de hotel vor putea sa:
////•	Managerieze camerele
////•	Adaugare camera
////•	Stergere camera
////•	Vizualizare camere
////•	Editare pret camera
////•	Sa vada cate camere sunt libere/ocupate pentru o anumita perioada
////•	Sa vada care este pretul obtinut din toate rezervarile dintr-o anumita perioada
public class UserAdministrator extends User {

    private  Hotel hotel;

    public UserAdministrator(Hotel hotel, String name) {
        super(name);
        this.hotel = hotel;
    }
    public  Hotel getHotel() {
        return this.hotel;
    }

    public  void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


    //adauga camera in lista de  camere

    public List<Room> addRoom(Room room) {
        hotel.getRooms().add(room); //din obiectul hotel accesesz lista de camere si adaug o camera
        return hotel.getRooms();
    }

    //sterg o camera din lista de camere
    public List<Room> deleteRoom(Room roomRemoved) {
        if (hotel.getRooms().contains(roomRemoved)) {
            hotel.getRooms().remove(roomRemoved);
        }
        return hotel.getRooms();
    }

    ////•	Vizualizare camere
    // ar trebui sa vad toate camerele practic sa returnez lista de camere ?
    public List<Room> viewRooms() {
        return hotel.getRooms();
    }

    ////•	Editare pret camera
    //pe o camera ar trebui sa mofific pretul - cum fac asta?
    //caut in lista de camere camera care o dau ca parametru si pentru acea camerea modific pretul
// cu pretul primit ca parametru
    public Room updatePricePerRoom(Integer roomNumber, int price) throws Exception {
        Room room = hotel.findRoomByNumber(roomNumber);
        room.setPricePerRoom(price);
        return room;
    }

    public int getNumberOfAvailableRoomsBy(LocalDate checkIn, LocalDate checkOut) {
        int numberOfAvailableRooms = 0;
        for (Room room : hotel.getRooms()) {
            if (room.getReservationList().isEmpty()) {
                numberOfAvailableRooms++;
            } else if (!room.isReservedRoomBetween(checkIn, checkOut)) {
                numberOfAvailableRooms++;
            }
        }
        return numberOfAvailableRooms;
    }

    //varaianta cu stream pe lista de camere a unui hotel filtrez camerele care nu sunt
    // rezervate in perioada selectata ca parametru in metoda

    public long findNumberOfAvailableRoomsBy(LocalDate checkIn, LocalDate checkOut) {
        return hotel.getRooms().stream()
                .filter(room -> !room.isReservedRoomBetween(checkIn, checkOut))
                .count();
    }
    //pretul obtinunt pentru o perioada data pe un hotel

    public long getPricesForAllReservationsByRoomBetween(LocalDate checkIn, LocalDate checkOut, Room room){
        long totalPrice = 0;
        long numberOfDaysReservedForTheRoom;
        for (Reservation reservation : room.getReservationList()) {
            if (room.isReservedRoomBetween(checkIn, checkOut)) {
                numberOfDaysReservedForTheRoom = ChronoUnit.DAYS.between(reservation.getCheckIn(), reservation.getCheckOut());
                totalPrice += room.getPricePerRoom() * numberOfDaysReservedForTheRoom;
            }
        }
        return totalPrice;
    }
    public long getPriceForAllReservationsBy(LocalDate checkIn, LocalDate checkOut) {
        long totalPrice = 0;
        for (Room room : hotel.getRooms()) {
            totalPrice += getPricesForAllReservationsByRoomBetween(checkIn, checkOut, room);
        }
        return totalPrice;
    }
    //varianta cu stream pe lista de camere si returnez pretul total
    // obtinut pentru o lista de camere rezervate

    public Integer findPriceForAllReservationsBy(LocalDate checkIn, LocalDate checkOut, Hotel hotel) {
        return hotel.getRooms().stream()
                .filter(room -> room.isReservedRoomBetween(checkIn, checkOut))
                .reduce((0), (sum, room) -> sum + (room.getRoomNumber() * (int) (ChronoUnit.DAYS.between(checkIn, checkOut))), Integer::sum);

    }
}


