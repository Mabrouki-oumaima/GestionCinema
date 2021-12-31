package com.example.gestioncinema2.Controlleurs;


import com.example.gestioncinema2.Classes.Film;
import com.example.gestioncinema2.ConnexionBD;
import com.example.gestioncinema2.Interfaces.IFilm;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmControlleur extends ConnexionBD implements IFilm {

    Connection con = Connect();
    @Override
    public boolean AjouterFilm(Film F) throws SQLException {
        boolean Resultat = true ;

             String Insert ="INSERT INTO film (titre,nomrealisateur,anneerealisation,description) values (?,?,?,?)" ;
        PreparedStatement PS =con.prepareStatement(Insert);
       try {
           PS.setString(1,F.getTitre());
           PS.setString(2,F.getNomRealisateur());
           PS.setString(3,F.getAnneeRealisation());
           PS.setString(4,F.getDescription());
        int row = PS.executeUpdate();
       if(row>0){
           System.out.println("Film Ajouté");

       }
       }catch (Exception E){
           System.out.println(E.getMessage());
           Resultat = false ;
       }
       return Resultat ;
    }

    @Override
    public boolean SupprimerFilm(String titre) throws SQLException {
        boolean Resultat = true;
        String Delete = "DELETE FROM film where titre=?";
        PreparedStatement PS = con.prepareStatement(Delete);
        try {
            PS.setString(1, titre);
            System.out.println();
            int row = PS.executeUpdate();
            // if row = 1 or more that means that request is done perfectly in the database if 0 or <0 that means there is a problem which
            // The Exception will handle it
            if (row > 0) {
                System.out.println("Film Supprimé");
            }
        } catch (SQLException SE) {
            System.out.println(SE.getMessage());
                    Resultat = false;
        }
        return Resultat;
    }
    @Override
    public boolean ModifierFilm(Film F) {
        boolean resultat = true;
        String modifier="UPDATE film SET nomrealisateur=?,anneerealisation=?,description=? WHERE titre=?";
        try{
            PreparedStatement PS = con.prepareStatement(modifier);
            PS.setString(1,F.getNomRealisateur());
            PS.setString(2,F.getAnneeRealisation());
            PS.setString(3,F.getDescription());
            PS.setString(4,F.getTitre());
            int row = PS.executeUpdate();
              if(row>0){
                  System.out.println("Mise a jour réussie");
              }
        }catch (Exception E){
            System.out.println(E.getMessage());
            resultat=false;
        }
        return resultat ;

    }

    @Override
    public List<Film> TousLesFilms() {
        String GetFilm="Select * from film";
        List<Film> LsFilm = new ArrayList<>();
        try{
            // j'ai utilisé Statement ici car Select est Static et on utilise Statement pour les requetes Static
            Statement S = con.createStatement();
            ResultSet RS = S.executeQuery(GetFilm);
            // on va parcourir par ligne notre resultat .next
            while(RS.next()){
                Film F = new Film();
                F.setDescription(RS.getString(4));
                F.setTitre(RS.getString(1));
                F.setNomRealisateur(RS.getString(2));
                F.setAnneeRealisation(RS.getString(3));
                LsFilm.add(F);
            }
        }catch (Exception E){
            System.out.println(E.getMessage());
        }
        return LsFilm;
    }

    @Override
    public Film RechercherFilm(String titre) throws SQLException {
        String GetFilm = "select * from film where titre='" + titre + "'";
        Statement S = con.createStatement();
        ResultSet RS = S.executeQuery(GetFilm);
        if (RS.next() == false) {
            System.out.println("Film Introuvable");
            return null;
        } else {
            Film F = new Film();
            F.setDescription(RS.getString(4));
            F.setTitre(RS.getString(1));
            F.setNomRealisateur(RS.getString(2));
            F.setAnneeRealisation(RS.getString(3));
            return F ;
        }
    }
}
