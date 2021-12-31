package com.example.gestioncinema2.Classes;



public class Seance extends Film {

    enum Tarif{
        Normal,
        reduit,
        Gratuit
    }
    Integer NumSeance;
    String TitreFilm;
    String DateHeure ;
    Integer idSalle ;
    String tarif;

    public String getTarif() {
        return tarif.toString();
    }

    public void setTarif(String tarif) {
        this.tarif = tarif.toString();
    }
    public Integer getNumSeance() {
        return NumSeance;
    }

    public void setNumSeance(Integer numSeance) {
        NumSeance = numSeance;
    }

    public String getTitreFilm() {
        return TitreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        TitreFilm = titreFilm;
    }

    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public String getDateHeure() {
        return DateHeure;
    }

    public void setDateHeure(String dateHeure) {
        DateHeure = dateHeure;
    }


}
