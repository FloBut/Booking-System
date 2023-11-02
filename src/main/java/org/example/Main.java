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
        Scanner console = new Scanner(System.in);


        Hotel hotel1 = new Hotel("Continental");
        Hotel hotel2 = new Hotel("Grand");
        Hotel hotel3 = new Hotel("Litoral");

        Admin admin = new Admin("Cist", "Voinea");
        Booking booking = new Booking();
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

        Reservation reservation1 = new Reservation(room2, LocalDate.of(2022, 8, 20), LocalDate.of(2022, 8, 22));
        Reservation reservation2 = new Reservation(room2, LocalDate.of(2022, 8, 28), LocalDate.of(2022, 8, 29));
        hotel1.getRooms().get(1).getReservationList().add(reservation1);
        hotel1.getRooms().get(1).getReservationList().add(reservation2);



        UserAdministrator admin1 = new UserAdministrator(hotel1);
        booking.getUserList().add(admin1);

        UserAdministrator userAdministrator1 = new UserAdministrator(hotel1);
        booking.getUserList().add(userAdministrator1);

        UserAdministrator userAdministrator2 = new UserAdministrator(hotel1);
        booking.getUserList().add(userAdministrator2);
        UserClient userClient1 = new UserClient("Valeriu", "Costin");



        accessedAdminMenuInLoop(admin, booking.getHotelList().get(0),console);

        accessedClientMenuInLoop(userClient1, booking, booking.getHotelList().get(0), console);
    }

    public static void accessedAdminMenuInLoop(Admin admin, Hotel hotel, Scanner console) {
        int option = 0;
        do {
            printAdminMenu();
            performSelectedActionForAdmin(admin, hotel, option, console);
        } while (option != 7);
    }

    public static void accessedClientMenuInLoop(UserClient client1, Booking booking, Hotel hotel, Scanner console) {
        int option;
        do {
            printClientMenu();
            option = 5;
            performSelectedActionForClient(client1, booking, hotel, option, console);
        } while (option != 4);
    }

    public static void performSelectedActionForAdmin(Admin admin, Hotel hotel, int option, Scanner console) {
        switch (option) {
            case 1:
                System.out.println("Add a new hotel room ");
                System.out.println("Enter the room number");
                int roomNumber = 5;
                System.out.println("Enter the price per night of the room");
                int pricePerNight = 350;
                System.out.println("Enter the number of people who can stay in the room");
                int numberOfPerson = 4;
                Room room = new Room(roomNumber, pricePerNight, numberOfPerson);
                admin.addRoom(room, hotel);
                break;
            case 2:
                System.out.println("Enter the number of the room you want to delete ");
                roomNumber = 4;
                try {
                    admin.removeRoom(roomNumber, hotel);
                } catch (RoomNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                admin.printAllRooms(hotel);
                break;
            case 4:
                System.out.println("Enter the number of the room you want to edit price ");
                roomNumber = 4;
                System.out.println("Enter the new price for the room ");
                int newPrice = 300;
                try {
                    admin.editPriceOfRoom(hotel, roomNumber, newPrice);
                } catch (RoomNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                System.out.println("Enter the check-in date");
                String stringCheckIn = console.next();
                LocalDate checkIn = LocalDate.parse(stringCheckIn);
                System.out.println("Enter the check-out date");
                String stringCheckout = console.next();
                LocalDate checkOut = LocalDate.parse(stringCheckout);
                System.out.println(admin.getNumberOfAvailableRoomsBy(checkIn, checkOut, hotel));
                System.out.println("java8: " + admin.findNumberOfAvailableRoomsBy(checkIn, checkOut, hotel));
                break;
            case 6:
                System.out.println("Enter the check-in date");
                stringCheckIn = console.next();
                checkIn = LocalDate.parse(stringCheckIn);
                System.out.println("Enter the check-out date");
                stringCheckout = console.next();
                checkOut = LocalDate.parse(stringCheckout);
                System.out.println("The price obtained from all reservations for the entered period: " + admin.getPriceForAllReservationsBy(checkIn, checkOut, hotel));
                System.out.println("java8: " + admin.findPriceForAllReservationsBy(checkIn, checkOut, hotel));
                break;
            case 7:
                System.out.println("You have exited the admin menu");
                break;
            default:
                System.out.println("The entered option is invalid, try again!");
        }
    }

    public static void performSelectedActionForClient(UserClient client, Booking booking, Hotel hotel,int option, Scanner console) {
        switch (option) {
            case 1:
                System.out.println("Enter the check-in date");
                String stringCheckIn = console.next();
                LocalDate checkIn = LocalDate.parse(stringCheckIn);
                System.out.println("Enter the check-out date");
                String stringCheckout = console.next();
                LocalDate checkOut = LocalDate.parse(stringCheckout);
                System.out.println("Enter the number of people who can stay in the room");
                int numberOfPerson = console.nextInt();
                System.out.println("The list of available rooms during the period " + checkIn + " - " + checkOut + " are: ");
                System.out.println(client.getAvailabilityRoom(checkIn, checkOut, numberOfPerson, booking));
                System.out.println("java8: " + client.findAvailableRoomsBy(checkIn, checkOut, numberOfPerson, booking));
                break;
            case 2:
                System.out.println("Enter the check-in date");
                stringCheckIn = console.next();
                checkIn = LocalDate.parse(stringCheckIn);
                System.out.println("Enter the check-out date");
                stringCheckout = console.next();
                checkOut = LocalDate.parse(stringCheckout);
                System.out.println("Enter the number of people who can stay in the room");
                numberOfPerson = console.nextInt();
                System.out.println("The sorted list with the available rooms by price for a certain period and a certain number of places is: ");
                System.out.println(client.getAvailableRoomsOrderedByPriceBy(checkIn, checkOut, numberOfPerson, booking));
                System.out.println("java8: " + client.findAvailableRoomsOrderedByPriceBy(checkIn, checkOut, numberOfPerson, booking));
                break;
            case 3:
                System.out.println("Enter the check-in date");
                stringCheckIn = console.next();
                checkIn = LocalDate.parse(stringCheckIn);
                System.out.println("Enter the check-out date");
                stringCheckout = console.next();
                checkOut = LocalDate.parse(stringCheckout);
                System.out.println("Enter the number of the room you want to book ");
                int roomNumber = console.nextInt();
                try {
                    client.bookARoom(roomNumber, hotel, checkIn, checkOut);
                } catch (RoomNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.println("You have exited the client menu");
                break;
            default:
                System.out.println("The entered option is invalid, try again!");
        }
    }

    public static void printAdminMenu() {
        System.out.println("ADMIN MENU:");
        System.out.println("1. Add a new hotel room ");
        System.out.println("2. Delete a room from the hotel ");
        System.out.println("3. Show all hotel rooms ");
        System.out.println("4. Edit the price of a hotel room ");
        System.out.println("5. Shows how many rooms are free/occupied for a certain period ");
        System.out.println("6. Shows the price obtained from all the reservations from a certain period ");
        System.out.println("7. Exit the admin menu");
        System.out.println("_________________________________________");
        System.out.println("Choose the action with the number: ");
    }

    public static void printClientMenu() {
        System.out.println("CLIENT MENU:");
        System.out.println("1. Show the rooms that are available in a certain period");
        System.out.println("2. Show the available rooms sorted by price for a certain period and a certain number of places");
        System.out.println("3. Make a reservation for a specific room");
        System.out.println("4. Exit the client menu");
        System.out.println("_________________________________________");
        System.out.println("Choose the action with the number: ");
    }


}
