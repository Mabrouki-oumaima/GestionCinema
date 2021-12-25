package com.company.Classes;


public class Seance extends Film {

    Film Film;
    String DateHeure ;
    Salle Salle ;

    public Film getFilm() {
        return Film;
    }

    public void setFilm(Film film) {
        Film = film;
    }

    public String getDateHeure() {
        return DateHeure;
    }

    public void setDateHeure(String dateHeure) {
        DateHeure = dateHeure;
    }

    public Salle getSalle() {
        return Salle;
    }

    public void setSalle(Salle salle) {
        Salle = salle;
    }
}
