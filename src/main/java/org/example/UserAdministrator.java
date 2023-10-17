package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        //parcurg lista de camere si daca camera care este data ca parametru sa gaseste in lista de camere o sterg cu remove
        // cu expresie lambda:
            // fac un stream pe lista de camere si filtrez lista care nu contine acea camera, practic nu este o stergere
            // ci construiesc o alta lista in  doar o lista
            //folosesc removeALL si sterg din lista acea camera
        List<Room> roomToBeRemoved = new ArrayList<>();
        return roomToBeRemoved = rooms.stream()
                .filter(room ->!(rooms.contains(roomRemoved)))
                .collect(Collectors.toList());
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
////•	Sa vada cate camere sunt libere/ocupate pentru o anumita perioada
    //ar trebui sa setez disponibilitatea camerei - >enum Availability si perioada?
    //fac 2 metode in care vad lista de camere in functie de parametru ?

    public List<Room>  viewAvailabilityRoom () {
        ///aici as putea sa ma folosesc de un colector
        return rooms.stream()
              .filter(room -> rooms.contains(Availability.YES)).toList();
    }

    ////•	Sa vada care este pretul obtinut din toate rezervarile dintr-o anumita perioada
    //ar trebui sa fac o metoda care imi returneaza o valoare de tip double si in care dau ca parametru checkin si checkout
        //ar trebui sa verific care sunt camerele care sunt rezervate in acea perioada si fac o suma totala pe acele camere
        //cum fac asta?


}
