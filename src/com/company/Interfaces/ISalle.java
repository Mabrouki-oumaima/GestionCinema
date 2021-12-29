package com.company.Interfaces;

import com.company.Classes.Salle;

import java.sql.SQLException;

public interface ISalle {
    Salle RechercherSalle(int idSalle) throws SQLException;
}
