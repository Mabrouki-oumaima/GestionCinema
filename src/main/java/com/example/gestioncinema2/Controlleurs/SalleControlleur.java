package com.example.gestioncinema2.Controlleurs;


import com.example.gestioncinema2.Classes.Salle;
import com.example.gestioncinema2.ConnexionBD;
import com.example.gestioncinema2.Interfaces.ISalle;

import java.sql.*;

public class SalleControlleur extends ConnexionBD implements ISalle {

    Connection con = Connect();

    @Override
    public Salle RechercherSalle(int idSalle) throws SQLException {
        String getSalle = "select * from salle where NumeroSalle='"+idSalle+"'";
        Statement S = con.createStatement();
        ResultSet RS = S.executeQuery(getSalle);
        if(RS.next()==false){
            System.out.println("Salle Introuvable");
            return null ;
        }else{
            Salle SS = new Salle();
            SS.setStatut(RS.getBoolean(3));
            SS.setNumeroSalle(RS.getInt(1));
            SS.setNbrPlaces(RS.getInt(2));
            return SS ;
        }

    }

    @Override
    public boolean AjouterSalle(Salle S) throws SQLException {
        boolean Resultat = true ;
        String insert = "Insert into salle (NumeroSalle,NbrPlaces,Statut) values (?,?,?)";
        PreparedStatement PS = con.prepareStatement(insert);
        PS.setInt(1,S.getNumeroSalle());
        PS.setInt(2,S.getNbrPlaces());
        PS.setBoolean(3,S.isStatut());
        int x =PS.executeUpdate();
        if(x>0){
            System.out.println("Salle Ajoutée");

        }else Resultat=false;

        return Resultat ;
    }
}
