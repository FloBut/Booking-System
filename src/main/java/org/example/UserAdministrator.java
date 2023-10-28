package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
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
public class UserAdministrator {

    private static Hotel hotel;

    public UserAdministrator(Hotel hotel) {
        this.hotel = hotel;
    }


    public static Hotel getHotel() {
        return hotel;
    }

    public static void setHotel(Hotel hotel) {
        UserAdministrator.hotel = hotel;
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
    public List<Room> viewRoom() {
        return hotel.getRooms();
    }

    ////•	Editare pret camera
    //pe o camera ar trebui sa mofific pretul - cum fac asta?
    //caut in lista de camere camera care o dau ca parametru si pentru acea camerea modific pretul
// cu pretul primit ca parametru
    public List<Room> pricePerRoom(Room roomModifiedPrice, double price) {
        //&& hotel.rooms.get(i).availability.equals(Availability.YES
        for (int i = 0; i < hotel.rooms.size(); i++) {
            if (hotel.rooms.get(i).equals(roomModifiedPrice)) {
                //pretul pe acea camera va lua valoarea lui price doar daca camera este disponibila altfel arunca exceptie
                hotel.rooms.get(i).setPricePerRoom(price);
            }
        }
        return hotel.rooms;
    }

    //tu vezi daca o camera este disponibila intre doua date
    //ar trebui ca acele doua date sa fie transmise ca parametru metodei
    //prin 2 variabile de tip LocalDate (start si end) (edited)
    //si cum stii ca o camera este rezervata?
    //pai daca in lista de rezervari a camerei gasesti o rezervare care sa aiba checkout-ul dupa start si
    // checkin-ul inainte de end


    public List<Reservation> getAvailabilityRoom(Room reservedRoom, LocalDate checkIn, LocalDate checkOut) {
        //voi return o lista de rezervari disponibile
        List<Reservation> availabilityRoom = new ArrayList<>();
        //parcurg lista de rezervari si verific daca exita o rezervare in perioada repectiva atunci adug in lista
        // doar rezervarile disponibile
        // rezervarea sa aiba check in si check out egale cu datele date ca parametru
        for (Room r : hotel.getRooms()) {
            if (r.equals(reservedRoom)) {
                boolean isAvailable = true;
                for (Reservation reservation : reservedRoom.getReservation()) {
                    if (!(reservation.getCheckOut().isBefore(ChronoLocalDate.from(checkIn)) ||
                            reservation.getCheckIn().isAfter(ChronoLocalDate.from(checkOut)))) {
                        isAvailable = false;
                        break;
                    }
                }
                availabilityRoom.add(new Reservation(reservedRoom, checkIn, checkOut));
            }
        }
        return availabilityRoom;
    }
}



    ////•	Sa vada care este pretul obtinut din toate rezervarile dintr-o anumita perioada
    //ar trebui sa fac o metoda care imi returnee o valoare de tip double si in care dau ca parametru checkin si checkout
    //ar trebui sa verific care sunt camerele care sunt rezervate in acea perioada si fac o suma totala pe acele camere
    //cum fac asta?

//        public double getPricePerReservation(LocalDate checkIn, LocalDate checkOut) {
//            double totalPrice = 0.00;
//        //ma folosesc de lista returnata mai sus si pe acea lista fac calculul pentru camerele rezervate in acea perioada
//            List<Reservation> pricePerReservation = getAvailabilityRoom (checkIn,checkOut);
//            //parcurg lista si pentru fiecare camera care are o lisa de rezervari calculez pretul
