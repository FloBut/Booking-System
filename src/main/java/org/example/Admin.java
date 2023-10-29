package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.example.UserAdministrator.hotel;

public class Admin  extends User {


    //daca extinde user atunci va mosteni numele si prenumele din clasa user
    public Admin(String lastName, String firstName) {
        super(lastName, firstName);
    }

    //adaug un hotel in lista de hoteluri
    public void addHotel(Hotel hotel, Booking booking) {
        booking.getHotelList().add(hotel);
    }

    //adaug o camera in lista de camere

    public void addRoom(Room room, Hotel hotel) {
        hotel.setHotelName(hotel.getHotelName());
        hotel.getRooms().add(room);
    }

    // sterg o camera din lista de camere
    public void removeRoom(int numberRoom, Hotel hotel) throws RoomNotFoundException {
        Room room = hotel.getRoomFromHotelByNumber(numberRoom);
        if (room == null) {
            throw new RoomNotFoundException("The room with numberRoom " + numberRoom + " is not in the hotel " + hotel.getHotelName());
        }
        hotel.getRooms().remove(room);
    }


    //numarul de camere disponibile intr un hotel pe intr o perioada
    public int getNumberOfAvailableRoomsBy(LocalDate checkIn, LocalDate checkOut, Hotel hotel) {
        int numberOfAvailableRooms = 0;
        for (Room room : hotel.getRooms()) {
            if (room.getReservationList().isEmpty()) {
                numberOfAvailableRooms++;
            } else {
                for (Reservation reservation : room.getReservationList()) {
                    if ((reservation.getCheckOut().isBefore(checkIn) && reservation.getCheckIn().isAfter(checkOut))) {
                        numberOfAvailableRooms++;
                    }
                }
            }
        }
        return numberOfAvailableRooms;
    }

    public long findNumberOfAvailableRoomsBy(LocalDate checkIn, LocalDate checkOut, Hotel hotel) {
        return hotel.getRooms().stream()
                .filter(room -> !room.isReservedRoomBetween(checkIn, checkOut))
                .count();
    }

    public long getPriceForAllReservationsBy(LocalDate checkIn, LocalDate checkOut, Hotel hotel) {
        long totalPrice = 0;
        long numberOfDaysReservedForTheRoom;
        for (Room room : hotel.getRooms()) {
            for (Reservation reservation : room.getReservationList()) {
                if (reservation.getCheckOut().isAfter(checkIn) && reservation.getCheckIn().isBefore(checkOut)) {
                    numberOfDaysReservedForTheRoom = ChronoUnit.DAYS.between(reservation.getCheckIn(), reservation.getCheckOut());
                    totalPrice += room.getPricePerRoom() * numberOfDaysReservedForTheRoom;
                }
            }
        }
        return totalPrice;
    }

    public Integer findPriceForAllReservationsBy(LocalDate checkIn, LocalDate checkOut, Hotel hotel) {
        return hotel.getRooms().stream()
                .filter(room -> room.isReservedRoomBetween(checkIn, checkOut))
                .reduce((0), (sum, room) -> sum + (room.getRoomNumber() * (int) (ChronoUnit.DAYS.between(checkIn, checkOut))), Integer::sum);

    }
}
