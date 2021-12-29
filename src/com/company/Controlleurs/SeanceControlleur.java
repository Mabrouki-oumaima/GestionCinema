package com.company.Controlleurs;

import com.company.Classes.Seance;
import com.company.Interfaces.ISeance;

public class SeanceControlleur implements ISeance {

    @Override
    public boolean AjouterSeance(Seance S) {
        boolean Resultat = true ;
        String insert = "INSERT INTO seance(NumSeance,DateHeure,idSalle,Tarif,TitreFilm) values (?,?,?,?,?)";
    }
}
