package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



////Un utilizator are o lista de rezervari, nume, prenume.
////Clinetii vor putea sa:
////•	Vada disponibilitatile (camerele libere) pentru o anumita perioada si un anumit numar de locuri
////•	Adica sa vada care camere sunt disponibile intr-o anumita perioada
////•	Sorteze disponibilitatile (camerele libere) dupa pret pentru o anumita perioada si un anumit numar de locuri
////•	Faca o rezervare pentru o anumita camera
public class UserClient extends User {

    List<Reservation> reservationList;
    public UserClient(String name) {
        super(name);
        this.reservationList=new ArrayList<>();
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public List<Room> getAvailabilityRoom(LocalDate checkIn, LocalDate checkOut, int numberOfPerson, Hotel hotel) {
        //voi return o lista de rezervari disponibile
        List<Room> availabilityRoom = new ArrayList<>();
        //parcurg lista de rezervari si verific daca exita o rezervare in perioada repectiva atunci adug in lista
        // doar rezervarile disponibile
        // rezervarea sa aiba check in si check out egale cu datele date ca parametru

        for (Room room : hotel.getRooms()) {
            if (room.getNoPersonByRoom() == numberOfPerson) {
                if (room.getReservationList().isEmpty()) {
                    availabilityRoom.add(room);
                } else if (!room.isReservedRoomBetween(checkIn, checkOut)) {
                    availabilityRoom.add(room);
                }
            }
        }
        return  availabilityRoom;

    }






//aceasi metoda folosind expresii lambda

    public List<Room> findAvailableRoomsBy(LocalDate checkIn, LocalDate checkOut, int numberOfPerson, Hotel hotel) {
        return  hotel.getRooms().stream()
                .filter(room -> !room.isReservedRoomBetween(checkIn, checkOut) && room.getNoPersonByRoom() == numberOfPerson)
                .collect(Collectors.toList());
    }
// metoda sorteaza crescator  in functie de pret lista de camere disponibile

    public List<Room> getAvailableRoomsOrderedByPriceBy(LocalDate checkIn, LocalDate checkOut, int numberOfPerson, Hotel hotel) {
        List<Room> listOfAvailableRooms = findAvailableRoomsBy(checkIn, checkOut, numberOfPerson, hotel);
        Collections.sort(listOfAvailableRooms);
        //listOfAvailableRooms.sort((r1,r2)-> Integer.compare(r1.getPricePerRoom(), r2.getPricePerRoom()));
        return listOfAvailableRooms;
    }


    //varianta de sortare crescatoare a preturilor camerelor dupa aexpresii lamba
//    public List<Room> findAvailableRoomsOrderedByPriceBy(LocalDate checkIn, LocalDate checkOut, int numberOfPerson) {
//        List<Room> collect = booking.getHotelList().stream()
//                .flatMap(hotel -> hotel.getRooms().stream())
//                .filter(room -> !room.isReservedRoomBetween(checkIn, checkOut) && room.getNoPersonByRoom() == numberOfPerson)
//                .sorted(Comparator.comparingInt(Room::getPricePerRoom))
//                .collect(Collectors.toList());
//        return collect;
//    }

    //metoda de rezervare a unei camere in cazul in care camera nu exista (nu am index > 0) ATUNCI RETURNEZ O EXEPTIE decat

    public Reservation bookARoom(int roomNumber, Hotel hotel, LocalDate checkIn, LocalDate checkOut) throws Exception {
        //caut camera care are roomNumber in hotel
        Room room = hotel.findRoomByNumber(roomNumber);
        //verific daca camera e disponibila
        if (room.isReservedRoomBetween(checkIn, checkOut)){
            throw new Exception("room already booked");
        }
        Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
        room.getReservationList().add(reservation);
        this.reservationList.add(reservation);
        //creez o rezervare pentru camera mea
            //adaug rezervarea in lista de rezervari a camerei
        return reservation;
    }
}
