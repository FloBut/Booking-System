package org.example;

import java.time.LocalDateTime;
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

    private static List<Room> rooms;
    private static List<Reservation> reservations;

    public UserAdministrator(List<Room> rooms) {

        this.rooms = rooms;
    }
    //nu stiu ce ar trebui sa pun in metoda aceasta
    public void manageRoom() {
    }

    //adauga camera in lista de camere

    public List<Room> addRoom(Room room) {
       rooms.add(room);
       return rooms;
    }

        //sterg o camera din lista de camere
        //nu merge sa sterg o camera din lista de camere cu filtru
    public List<Room> deleteRoom(Room roomRemoved) {
        // era o proprietate
        //tu faci stream si procesezi lista ta, insa dupa ce iesi in stream, lista originala nu se modifica
        //deci rooms nu se va modifica
        //insa poti pur si simplu sa te folosesti de metode remove de la arraylist fara stream
            //parcurg lista de camere si daca camera care este data ca parametru sa gaseste in lista de camere o sterg cu remove
            // cu expresie lambda:
                // fac un stream pe lista de camere si filtrez lista care nu contine acea camera, practic nu este o stergere
                // ci construiesc o alta lista in  doar o lista
                //folosesc removeALL si sterg din lista acea camera
            if (rooms.contains(roomRemoved)) {
                rooms.remove(roomRemoved);
            }
       return rooms;
    }

    ////•	Vizualizare camere
        // ar trebui sa vad toate camerele practic sa returnez lista de camere ?
    public List<Room> viewRoom() {

        return rooms;
    }

////•	Editare pret camera
    //pe o camera ar trebui sa mofific pretul - cum fac asta?
        //caut in lista de camere camera care o dau ca parametru si pentru acea camerea modific pretul
// cu pretul primit ca parametru
    public  List<Room> pricePerRoom(Room roomModifiedPrice, double price) {
      for (Room r : rooms) {
          if (r.equals(roomModifiedPrice)) {
              //pretul pe acea camera va lua valoarea lui price
              r.setPricePerRoom(price);
          }
      }
      return rooms;
    }
// atat userclientul tre sa vada lista de camere disponilbila cat si userAdministratorul
    //tu vezi daca o camera este disponibila intre doua date
    //ar trebui ca acele doua date sa fie transmise ca parametru metodei
    //prin 2 variabile de tip LocalDate (start si end) (edited)
    //si cum stii ca o camera este rezervata?
    //pai daca in lista de rezervari a camerei gasesti o rezervare care sa aiba checkout-ul dupa start si checkin-ul inainte de end


        public List<Reservation> getAvailabilityRoom (LocalDateTime checkIn, LocalDateTime checkOut) {
        //voi return o lista de rezervari disponibile
        List<Reservation>  availabilityRoom = new ArrayList<>();
        //parcurg lista de rezervari si verific daca exita o rezervare in perioada repectiva atunci adug in lista
        // doar rezervarile disponibile
        // rezervarea sa aiba check in si check out egale cu datele date ca parametru

        for (int i = 0; i < reservations.size(); i++) {
            if (!(reservations.get(i).getCheckIn().equals(checkIn) && reservations.get(i).getCheckOut().equals(checkOut))) {
                availabilityRoom.add(reservations.get(i));
        }
       return availabilityRoom;
    }



    ////•	Sa vada care este pretul obtinut din toate rezervarile dintr-o anumita perioada
    //ar trebui sa fac o metoda care imi returneaza o valoare de tip double si in care dau ca parametru checkin si checkout
        //ar trebui sa verific care sunt camerele care sunt rezervate in acea perioada si fac o suma totala pe acele camere
        //cum fac asta?

    //adica trebuie sa gasesti inainte rezervarile care sunt intr-o anumite perioada si apoi sa calculezi pretul

    //pentru pretul rezervarilor dintr-o anumita perioada
    //e cam similar


        public double getPricePerReservation() {
            double totalPrice = 0.00;
        //ma folosesc de lista returnata mai sus si pe acea lista fac calculul pentru camerele rezervate in acea perioada
            List<Reservation> pricePerReservation = getAvailabilityRoom (LocalDateTime checkIn, LocalDateTime checkOut);
            //parcurg lista si pentru fiecare rezervare calculez pretul
        for (int i = 0; i < reservations.size(); i++) {
           totalPrice += reservations.get(i).getReservedNo().pricePerRoom;
        }
        return totalPrice;

        }

}
