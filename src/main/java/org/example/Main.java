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

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static java.time.LocalTime.parse;

public class Main {

    public static void main(String[] args) {

        Hotel hotel1 = new Hotel("Continental");

        UserAdministrator admin = new UserAdministrator(hotel1, "Admin");
        UserClient client = new UserClient("client");

        Room room1 = new Room(1, 250, 2);
        Room room2 = new Room(2, 150, 1);
        Room room3 = new Room(3, 300, 3);
        Room room4 = new Room(4, 250, 1);
        Room room5 = new Room(5, 450, 3);
        Room room6 = new Room(6, 150, 1);
        Room room7 = new Room(7, 250, 3);
        Room room8 = new Room(8, 350, 2);
        Room room9 = new Room(9, 250, 2);
        Room room10 = new Room(10, 350, 2);
        Room room11 = new Room(11, 370, 3);
        Room room12 = new Room(12, 230, 1);
        admin.addRoom(room1);
        admin.addRoom(room2);
        admin.addRoom(room3);
        admin.addRoom(room4);
        admin.addRoom(room5);
        admin.addRoom(room6);
        admin.addRoom(room7);
        admin.addRoom(room8);
        admin.addRoom(room9);
        admin.addRoom(room10);
        admin.addRoom(room11);
        admin.addRoom(room12);
        
        try {
            client.bookARoom(room2.getRoomNumber(), hotel1, LocalDate.of(2022, 8, 20), LocalDate.of(2022, 8, 22));
            client.bookARoom(room2.getRoomNumber(), hotel1, LocalDate.of(2022, 8, 28), LocalDate.of(2022, 8, 29));
            System.out.println(client.getAvailableRoomsOrderedByPriceBy(LocalDate.of(2022, 8, 18), LocalDate.of(2022, 8, 19), 1, hotel1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(room2.getReservationList());
    }
}
