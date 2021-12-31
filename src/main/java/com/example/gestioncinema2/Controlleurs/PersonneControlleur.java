package com.example.gestioncinema2.Controlleurs;
import com.example.gestioncinema2.Classes.Personne;
import com.example.gestioncinema2.ConnexionBD;
import com.example.gestioncinema2.Interfaces.IPersonne;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneControlleur extends ConnexionBD implements IPersonne {

    Connection conn= Connect();
    @Override
    public boolean Login(Personne P) throws SQLException, NoSuchAlgorithmException {
         boolean Result = true ;
        String sql ="select * from personne where CIN= '"+P.getCIN()+"'";
        ResultSet RS = conn.createStatement().executeQuery(sql);
        if(RS.next()==false){
            System.out.println("Utilisateur Non trouvé");
            Result = false;
        }else {
            if(HashPassword(P.getPassword())==RS.getString(3)){
                System.out.println("Utilisateur Trouvé");
                Result = true ;
            }else {
                System.out.println("Mot de passe erroné");
                Result=false;
            }
        }
        return Result ;
    }

    @Override
    public boolean SignIn(Personne P) throws SQLException, NoSuchAlgorithmException {
        boolean Resultat = true ;
        String InsertPersonne = "Insert into personne (CIN,Password) values(?,?)";
        PreparedStatement PS = conn.prepareStatement(InsertPersonne);
        PS.setString(1,P.getCIN());
        PS.setString(2,HashPassword(P.getPassword()));
        int i=PS.executeUpdate();
         if(i>0){
             System.out.println("Personne Ajouté");
         }else Resultat = false ;
         return Resultat ;
    }

    public String HashPassword(String password) throws NoSuchAlgorithmException {
        String generatedPassword=null;
        MessageDigest md =MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes=md.digest();
        StringBuilder SB = new StringBuilder();
        for(int i =0;i<bytes.length;i++){
            SB.append(Integer.toString((bytes[i]& 0xff)+0x100,16).substring(1));
        }
        generatedPassword=SB.toString();

        return generatedPassword;
    }
}
