package com.company.Interfaces;

import com.company.Classes.Seance;

import java.sql.SQLException;

public interface ISeance {
    boolean AjouterSeance(Seance S);
    Seance ChercherSeance(int idSeance) throws SQLException;
}
