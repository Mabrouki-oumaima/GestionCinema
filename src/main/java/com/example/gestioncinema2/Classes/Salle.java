package com.example.gestioncinema2.Classes;

public class Salle {
    Integer NumeroSalle;
    Integer NbrPlaces ;
    boolean Statut ;

    public boolean isStatut() {
        return Statut;
    }

    public void setStatut(boolean statut) {
        Statut = statut;
    }

    public Salle(Integer numeroSalle, Integer nbrPlaces, boolean statut) {
        NumeroSalle = numeroSalle;
        NbrPlaces = nbrPlaces;
        Statut = statut;
    }

    public Salle() {
    }

    public Integer getNumeroSalle() {
        return NumeroSalle;
    }

    public void setNumeroSalle(Integer numeroSalle) {
        NumeroSalle = numeroSalle;
    }

    public Integer getNbrPlaces() {
        return NbrPlaces;
    }

    public void setNbrPlaces(Integer nbrPlaces) {
        NbrPlaces = nbrPlaces;
    }
}
