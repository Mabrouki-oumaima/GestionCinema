package com.example.gestioncinema2.Interfaces;

import com.example.gestioncinema2.Classes.Seance;

import java.sql.SQLException;
import java.util.List;

public interface ISeance {
    boolean AjouterSeance(Seance S);
    Seance ChercherSeance(int idSeance) throws SQLException;
    List<Seance>AllSeances()throws SQLException ;
}
