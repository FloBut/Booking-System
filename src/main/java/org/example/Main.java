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
//Dupa ce aceasta versiune a aplicatiei functioneaza, permite ca in aplicatie sa existe mai multe hoteluri. Administratorul va putea adauga si hotel in aplicatie.

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }
}