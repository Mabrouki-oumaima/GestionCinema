package com.example.gestioncinema2.Classes;

public class Personne {
    Integer idP ;
    String CIN ;
    String Password ;

    public Personne(Integer idP, String CIN, String password) {
        this.idP = idP;
        this.CIN = CIN;
        Password = password;
    }

    public Personne() {
    }

    public Personne(String CIN, String password) {
        this.CIN = CIN;
        Password = password;
    }

    public Integer getIdP() {
        return idP;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
