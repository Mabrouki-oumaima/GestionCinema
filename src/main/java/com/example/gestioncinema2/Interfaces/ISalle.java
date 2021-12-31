package com.example.gestioncinema2.Interfaces;

import com.example.gestioncinema2.Classes.Salle;

import java.sql.SQLException;

public interface ISalle {
    Salle RechercherSalle(int idSalle) throws SQLException;
    boolean AjouterSalle(Salle S) throws  SQLException;
}
