package com.company.Classes;

public class Salle {
    Integer NumeroSalle;
    Integer NbrPlaces ;

    public Salle(Integer numeroSalle, Integer nbrPlaces) {
        NumeroSalle = numeroSalle;
        NbrPlaces = nbrPlaces;
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
