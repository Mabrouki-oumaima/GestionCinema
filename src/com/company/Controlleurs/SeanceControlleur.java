package com.company.Controlleurs;

import com.company.Classes.Film;
import com.company.Classes.Salle;
import com.company.Classes.Seance;
import com.company.ConnexionBD;
import com.company.Interfaces.ISeance;

import java.sql.*;

public class SeanceControlleur extends ConnexionBD implements ISeance {

     Connection con = Connect();
     FilmControlleur FC = new FilmControlleur();
     SalleControlleur SC = new SalleControlleur();
    @Override
    public boolean AjouterSeance(Seance S) {
        boolean Resultat = true ;
        String insert = "INSERT INTO seance(NumSeance,DateHeure,idSalle,Tarif,TitreFilm) values (?,?,?,?,?)";
        try{
        PreparedStatement PS = con.prepareStatement(insert);

            PS.setInt(1,S.getNumSeance());
            PS.setString(2,S.getDateHeure());
            Film F = FC.RechercherFilm(S.getFilm().getTitre());
            Salle SS = SC.RechercherSalle(S.getSalle().getNumeroSalle());
            if (SS!=null){
                PS.setInt(3,S.getSalle().getNumeroSalle());
            }else{
                System.out.println("Salle Introuvable");
                Resultat = false ;
            }
             if(F!=null){
                 PS.setString(5,S.getFilm().getTitre());
             }else  {
                 System.out.println("Film introuvable dans la Table Film");
                  Resultat=  false ;
             }
            PS.setString(4,S.getTarif());


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
            Film XX = new Film();
            XX.setTitre(RS.getString(3));
            SS.setFilm(XX);
            return SS ;
        }
    }
}
