package com.company.Classes;



public class Seance extends Film {

    enum Tarif{
        Normal,
        reduit,
        Gratuit
    }
    Integer NumSeance;
    Film Film;
    String DateHeure ;
    Salle Salle ;
    Tarif tarif;

    public String getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }
    public Integer getNumSeance() {
        return NumSeance;
    }

    public void setNumSeance(Integer numSeance) {
        NumSeance = numSeance;
    }
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
