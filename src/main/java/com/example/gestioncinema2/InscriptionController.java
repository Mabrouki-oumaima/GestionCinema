package com.example.gestioncinema2;

import com.example.gestioncinema2.Classes.Personne;
import com.example.gestioncinema2.Controlleurs.PersonneControlleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class InscriptionController {
    @FXML
    private TextField cin;
    @FXML
    private TextField password;
    @FXML
    private TextField confirm;

    public void Inscription(ActionEvent actionEvent) throws SQLException, NoSuchAlgorithmException, IOException {
        if ((cin.getText().isEmpty()) || (password.getText().isEmpty()) || (confirm.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dialogue");
            alert.setHeaderText("Attention");
            alert.setContentText("Mot de passe ou CIN vide !");
            alert.showAndWait();
            return;
        } else {
            if (!password.getText().equals(confirm.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Dialogue");
                alert.setHeaderText("Attention");
                alert.setContentText("les mots de passe ne sont pas identiques !");
                alert.showAndWait();
                return;
            } else {
                PersonneControlleur PC = new PersonneControlleur();
                Personne P = new Personne();
                P.setCIN(this.cin.getText());
                P.setPassword(this.password.getText());
                if (PC.SignIn(P)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information ");
                    alert.setHeaderText(null);
                    alert.setContentText("Bienvenue");


                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Information ");
                    alert.setHeaderText(null);
                    alert.setContentText("Utilisateur introuvable");
                    alert.showAndWait();
                }
            }
        }
    }
}
