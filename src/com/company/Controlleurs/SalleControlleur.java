package com.company.Controlleurs;

import com.company.Classes.Salle;
import com.company.ConnexionBD;
import com.company.Interfaces.ISalle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalleControlleur extends ConnexionBD implements ISalle {

    Connection con = Connect();

    @Override
    public Salle RechercherSalle(int idSalle) throws SQLException {
        String getSalle = "select * from salle where idSalle=?";
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
}
