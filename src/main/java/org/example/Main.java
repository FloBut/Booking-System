package org.example;

//22. Booking system (booking.com clone)
//Dezvolta un sistem de rezervari la hotel asemanator cu booking.com
//Aplicatia va avea 2 tipuri de utilizatori: administratori de hotel si clienti.
//O camera are numar, pret pe noapte, numar de persoane care pot fi cazate si o lista de rezervari
//O rezervare poate fi facuta pentru o camera, de catre un client, intre doua date (check in si check out).
//Un utilizator are o lista de rezervari, nume, prenume.
//Administratorii de hotel vor putea sa:
//•	Managerieze camerele
//•	Adaugare camera
//•	Stergere camera
//•	Vizualizare camere
//•	Editare pret camera
//•	Sa vada cate camere sunt libere/ocupate pentru o anumita perioada
//•	Sa vada care este pretul obtinut din toate rezervarile dintr-o anumita perioada
//Clinetii vor putea sa:
//•	Vada disponibilitatile (camerele libere) pentru o anumita perioada si un anumit numar de locuri
//•	Adica sa vada care camere sunt disponibile intr-o anumita perioada
//•	Sorteze disponibilitatile (camerele libere) dupa pret pentru o anumita perioada si un anumit numar de locuri
//•	Faca o rezervare pentru o anumita camera
//Dupa ce aceasta versiune a aplicatiei functioneaza, permite ca in aplicatie sa existe mai multe hoteluri.
// Administratorul va putea adauga si hotel in aplicatie.

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.time.LocalTime.parse;

public class Main {
    public static void main(String[] args) {

        //camerele
        Room room1= new Room(205, 100.25, 2, Availability.YES);
        Room room2 = new Room(206, 100.25, 2, Availability.YES);
        Room room3 = new Room(207, 100.25, 2, Availability.NO);
        Room room4= new Room(208, 100.25, 2, Availability.YES);
        Room room5 = new Room(209, 100.25, 4, Availability.NO);
        Room room6 = new Room(210, 100.25, 2, Availability.YES);
        Room room7= new Room(205, 100.25, 1, Availability.YES);

        //lista de camere
        List<Room> rooms = new ArrayList<>(List.of(room1, room2, room3, room4, room5, room6));

        //lista de rezervari pentru o camera
        List<Reservation> reservationList = new ArrayList<>();

        Reservation reservation1 = new Reservation(room3, LocalDate.parse("2023-01-07"),  LocalDate.parse("2023-01-15"));
        Reservation reservation2 = new Reservation(room3, LocalDate.parse("2023-05-07"),  LocalDate.parse("2023-05-15"));

        reservationList.add(reservation1);
        reservationList.add(reservation2);

        //lista de rezervari ar trebui sa o adaug pe o camera ?

        //hotelul
       Hotel hotel = new Hotel(rooms);

        UserAdministrator userAdministrator = new UserAdministrator(hotel);
        UserClient userClient = new UserClient("Popescu");
        UserClient userClient2 = new UserClient("Georgescu");

        //adauga camera in lista de camere
        userAdministrator.addRoom(room7);
        System.out.println(rooms);
        System.out.println("------------------");


        //sterg o camera din lista de camere
            //camera cu numarul 206 este stearsa

        userAdministrator.deleteRoom(room2);
        System.out.println(rooms);
        System.out.println("------------------");

        ////•	Vizualizare camere
            //afiseaza camerele

        userAdministrator.viewRoom();
        System.out.println(rooms);
        System.out.println("------------------");

        ////•	Editare pret camera
            //modfifica pretul pe camera doar daca camera este disponibila - > camera nu este disp
            // tre sa arunc o exceptie in aceasta metoda
        userAdministrator.pricePerRoom(room3, 1500);
        System.out.println(rooms);
        System.out.println("------------------");

        ////•	Editare pret camera
        //modfifica pretul pe camera doar daca camera este disponibila
        // pretul se modifica

        userAdministrator.pricePerRoom(room1, 50000.00);
        System.out.println(rooms);
        System.out.println("------------------");

        ////•daca camera data ca parametru este disponibila sau nu in acea perioada

        // //[Reservation{reservedRoomNo=Room{roomNumber=207, pricePerRoom=1500.0, noPersonByRoom=2, reservation=[], availability=NO}, userClient=null, checkIn=2023-01-07, checkOut=2023-01-15}, Reservation{reservedRoomNo=Room{roomNumber=207, pricePerRoom=1500.0, noPersonByRoom=2, reservation=[], availability=NO}, userClient=null, checkIn=2023-05-07, checkOut=2023-05-15}]
        //        //------------------
        //        //

        userAdministrator.getAvailabilityRoom(room3, LocalDate.parse("2023-02-07"), LocalDate.parse("2023-02-15"));
        System.out.println(reservationList.toString());
        System.out.println("------------------");







    }
}