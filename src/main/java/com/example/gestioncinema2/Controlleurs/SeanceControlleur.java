package com.example.gestioncinema2.Controlleurs;

import com.example.gestioncinema2.Classes.Film;
import com.example.gestioncinema2.Classes.Salle;
import com.example.gestioncinema2.Classes.Seance;
import com.example.gestioncinema2.ConnexionBD;
import com.example.gestioncinema2.Interfaces.ISeance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceControlleur extends ConnexionBD implements ISeance {

     Connection con = Connect();
     FilmControlleur FC = new FilmControlleur();
     SalleControlleur SC = new SalleControlleur();
    @Override
    public boolean AjouterSeance(Seance S) {
        boolean Resultat = true ;
        String insert = "INSERT INTO seance(NumSeance,Film,DateHeure,Salle,Tarif) values (?,?,?,?,?)";
        try{
        PreparedStatement PS = con.prepareStatement(insert);

            PS.setInt(1,S.getNumSeance());
            PS.setString(3,S.getDateHeure());
            Film F = FC.RechercherFilm(S.getTitreFilm());
            Salle SS = SC.RechercherSalle(S.getIdSalle());
            if (SS!=null){
                PS.setInt(4,S.getIdSalle());
            }else{
                System.out.println("Salle Introuvable");
                Resultat = false ;
            }
             if(F!=null){
                 PS.setString(2,S.getTitreFilm());
             }else  {
                 System.out.println("Film introuvable dans la Table Film");
                  Resultat=  false ;
             }
            PS.setString(5,S.getTarif());
             if((F!=null)&&(SS!=null)){
               int i= PS.executeUpdate();
               if(i>0){
                   System.out.println("Seance ajoutée avec Success");
               }
             }

        }catch (Exception E){
            System.out.println(E.getMessage()+"Probleme dans l'ajout ");
            Resultat= false ;
        }
        return Resultat;
    }

    @Override
    public Seance ChercherSeance(int idSeance) throws SQLException {
        String GetSeance ="select * from seance where idSeance='"+idSeance+"'";
        Statement S = con.createStatement();
        ResultSet RS = S.executeQuery(GetSeance);
        if(RS.next() == false ){
            System.out.println("Seance Introuvable");
            return null ;
        }else {
            Seance SS = new Seance();
            SS.setNumSeance(RS.getInt(1));
            SS.setDateHeure(RS.getString(2));
            SS.setIdSalle(RS.getInt(3));
            SS.setTarif(RS.getString(4));
            SS.setTitreFilm(RS.getString(5));

            return SS ;
        }
    }

    @Override
    public List<Seance> AllSeances() throws SQLException {
        List<Seance> LS = new ArrayList<>();
        String GetSeances = "select * from seance";
        Statement S = con.createStatement();
        ResultSet RS = S.executeQuery(GetSeances);
         if(RS.next()== false ){
             System.out.println("Table Seance vide");
             return null ;
         }else{
             while(RS.next()){
                 Seance SS = new Seance();
                 SS.setNumSeance(RS.getInt(1));
                 SS.setDateHeure(RS.getString(2));
                 SS.setIdSalle(RS.getInt(3));
                 SS.setTarif(RS.getString(4));
                 SS.setTitreFilm(RS.getString(5));
                 LS.add(SS);
             }
             return LS ;
         }
    }
}
