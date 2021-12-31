package com.example.gestioncinema2;

import java.sql.*;

public class ConnexionBD {

    public static Connection Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionCinema2","root","");
            //Verification si la connection est reussite
            if (con!=null){
                System.out.println("Connecté");
            }
            return con;
        }catch (Exception E){
            System.out.println(E.getMessage()+"Erreur dans la base de données");
        }
        return null ;
    }
}

