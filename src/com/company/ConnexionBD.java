package com.company;

import java.sql.*;

public class ConnexionBD {

    public  void Connect(Connection con){
        try{
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql//localhost:3306/GestionCinema","root","");
            //Verification si la connection est reussite
            if (con!=null){
                System.out.println("Connecté");
            }
        }catch (Exception E){
            System.out.println(E.getMessage()+"Erreur dans la base de données");
        }
    }
}

