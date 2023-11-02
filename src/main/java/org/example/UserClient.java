package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.reflect.Array.get;
import static org.example.UserAdministrator.hotel;

////Un utilizator are o lista de rezervari, nume, prenume.
////Clinetii vor putea sa:
////•	Vada disponibilitatile (camerele libere) pentru o anumita perioada si un anumit numar de locuri
////•	Adica sa vada care camere sunt disponibile intr-o anumita perioada
////•	Sorteze disponibilitatile (camerele libere) dupa pret pentru o anumita perioada si un anumit numar de locuri
////•	Faca o rezervare pentru o anumita camera
public class UserClient extends User {
    public UserClient(String lastName, String firstName) {
        super(lastName, firstName);
    }

    public List<Room> getAvailabilityRoom(LocalDate checkIn, LocalDate checkOut,int numberOfPerson, Booking booking) {
        //voi return o lista de rezervari disponibile
        List<Room> availabilityRoom = new ArrayList<>();
        //parcurg lista de rezervari si verific daca exita o rezervare in perioada repectiva atunci adug in lista
        // doar rezervarile disponibile
        // rezervarea sa aiba check in si check out egale cu datele date ca parametru
        for (Hotel hotel : booking.getHotelList()) {
            for (Room room: hotel.getRooms()) {
                if (room.getNoPersonByRoom() == numberOfPerson) {
                    if (room.getReservationList().isEmpty()) {
                        availabilityRoom.add(room);
                    } else {
                        for (Reservation reservation: room.getReservationList()) {
                            if (reservation.getCheckOut().isBefore(checkIn) && reservation.getCheckIn().isAfter(checkOut)) {
                                availabilityRoom.add(room);
                            }
                        }
                    }
                }
            }
        }
        return availabilityRoom;
    }

//aceasi metoda folosind expresii lambda

    public List<Room> findAvailableRoomsBy(LocalDate checkIn, LocalDate checkOut, int numberOfPerson, Booking booking) {
        return booking.getHotelList().stream()
                .flatMap(hotel -> hotel.getRooms().stream())
                .filter(room -> !room.isReservedRoomBetween(checkIn, checkOut) && room.getNoPersonByRoom() == numberOfPerson)
                .collect(Collectors.toList());
    }
// metoda sorteaza crescator  in functie de pret lista de camere disponibile

    public List<Room> getAvailableRoomsOrderedByPriceBy(LocalDate checkIn, LocalDate checkOut, int numberOfPerson, Booking booking) {
        List<Room> sortedListOfAvailableRooms = getAvailabilityRoom(checkIn, checkOut, numberOfPerson, booking);
        Collections.sort(sortedListOfAvailableRooms);
        return sortedListOfAvailableRooms;
    }


    //varianta de sortare crescatoare a preturilor camerelor dupa aexpresii lamba
    public List<Room> findAvailableRoomsOrderedByPriceBy(LocalDate checkIn, LocalDate checkOut, int numberOfPerson, Booking booking) {
        List<Room> collect = booking.getHotelList().stream()
                .flatMap(hotel -> hotel.getRooms().stream())
                .filter(room -> !room.isReservedRoomBetween(checkIn, checkOut) && room.getNoPersonByRoom() == numberOfPerson)
                .sorted(Comparator.comparingInt(Room::getPricePerRoom))
                .collect(Collectors.toList());
        return collect;
    }

    //metoda de rezervare a unei camere in cazul in care camera nu exista (nu am index > 0) ATUNCI RETURNEZ O EXEPTIE decat

    public void bookARoom(int roomNumber, Hotel hotel, LocalDate checkIn, LocalDate checkOut) throws RoomNotFoundException {
        int indexOfRoom = hotel.getIndexOfRoomFromHotelBy(roomNumber);
        if (indexOfRoom == -1) {
            throw new RoomNotFoundException("The room with numberRoom " + roomNumber + " is not in the hotel " + hotel.getHotelName());
        }

        // AICI NU INTELEG  FACE O REZERVARE : hotel.getRooms().get(indexOfRoom).getRoomNumber() - >
            // hotelul are o lista de camere, pe lista de camere obtin indexul camerei si din index obtin numarul camerei ,
            // de ce nu merge??

//        Reservation reservation = new Reservation(hotel.getRooms().get(indexOfRoom).getRoomNumber(), checkIn, checkOut);
//        reservationList.add(reservation);
//        hotel.getRooms().get(indexOfRoom).getReservationList().add(reservation);
    }
}
