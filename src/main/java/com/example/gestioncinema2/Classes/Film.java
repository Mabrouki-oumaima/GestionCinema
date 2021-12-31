package com.example.gestioncinema2.Classes;

public class Film {
    String  Titre;
    String  NomRealisateur;
    String  AnneeRealisation;
    String  Description ;

    public Film(String titre, String nomRealisateur, String anneeRealisation, String description) {
        Titre = titre;
        NomRealisateur = nomRealisateur;
        AnneeRealisation = anneeRealisation;
        Description = description;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getNomRealisateur() {
        return NomRealisateur;
    }

    public void setNomRealisateur(String nomRealisateur) {
        NomRealisateur = nomRealisateur;
    }

    public String getAnneeRealisation() {
        return AnneeRealisation;
    }

    public void setAnneeRealisation(String anneeRealisation) {
        AnneeRealisation = anneeRealisation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Film() {
    }


}
