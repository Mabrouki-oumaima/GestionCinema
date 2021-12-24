package com.company.Interfaces;

import com.company.Classes.Film;

import java.sql.SQLException;

public interface IFilm {
    boolean AjouterFilm(Film F) throws SQLException;
    boolean SupprimerFilm(String titre) throws SQLException;
    boolean ModifierFilm(Film FS);
    void TousLesFilms();
}
