package com.example.gestioncinema2;

import com.example.gestioncinema2.Classes.Personne;
import com.example.gestioncinema2.Controlleurs.PersonneControlleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private TextField CIN;
    @FXML
    private TextField Password;

    private Stage stage ;

    @FXML
    public void Log(ActionEvent actionEvent) {


        PersonneControlleur PC = new PersonneControlleur();
        Personne P = new Personne();
        if ((CIN.getText().isEmpty()) || (Password.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dialogue");
            alert.setHeaderText("Attention");
            alert.setContentText("Mot de passe ou CIN vide !");
            alert.showAndWait();
            return;

        } else {
            try {
                P.setCIN(this.CIN.getText());
                P.setPassword(this.Password.getText());
                if (PC.Login(P)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information ");
                    alert.setHeaderText(null);
                    alert.setContentText("Bienvenue");
                    alert.showAndWait();
                    return;
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur ");
                    alert.setHeaderText(null);
                    alert.setContentText("Mot de passe erroné");
                    alert.showAndWait();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex.getMessage());

            }
        }
    }

    public void SignIn(ActionEvent actionEvent) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Inscription");
        stage.setScene(new Scene(root));
        stage.show();
    }
}



