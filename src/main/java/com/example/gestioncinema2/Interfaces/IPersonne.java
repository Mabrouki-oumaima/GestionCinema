package com.example.gestioncinema2.Interfaces;


import com.example.gestioncinema2.Classes.Personne;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface IPersonne {
   boolean Login(Personne P) throws SQLException, NoSuchAlgorithmException;
   boolean SignIn(Personne P) throws SQLException, NoSuchAlgorithmException;
}
