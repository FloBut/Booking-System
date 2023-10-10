package org.example;
////Un utilizator are o lista de rezervari, nume, prenume.
////Clinetii vor putea sa:
////•	Vada disponibilitatile (camerele libere) pentru o anumita perioada si un anumit numar de locuri
////•	Adica sa vada care camere sunt disponibile intr-o anumita perioada
////•	Sorteze disponibilitatile (camerele libere) dupa pret pentru o anumita perioada si un anumit numar de locuri
////•	Faca o rezervare pentru o anumita camera
public class UserClient {
    private String nume;
    private Reservation reservation;

    public UserClient(String nume, Reservation reservation) {
        this.nume = nume;
        this.reservation = reservation;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
