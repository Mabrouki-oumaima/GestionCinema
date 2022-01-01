package com.example.gestioncinema2;

import com.example.gestioncinema2.Classes.Film;
import com.example.gestioncinema2.Controlleurs.FilmControlleur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdministrationController implements Initializable {
    @FXML
    private TableView<Film> TabViewFilm;
    @FXML
    private TableColumn<Film,String> TitreC;
    @FXML
    private TableColumn<Film,String> NomRealisateurC;
    @FXML
    private TableColumn<Film,String> AnneeC;
    @FXML
    private TableColumn<Film,String> DescriptionS ;

    @FXML
    private Tab TabGestionFilms;

    FilmControlleur FC = new FilmControlleur();
    ObservableList<Film> ObList = FXCollections.observableArrayList();
    public void AjouterB(ActionEvent actionEvent) {
      //TODO : ADD Event to FILM Button
        if(TabViewFilm.getSelectionModel().getSelectedItem()!=null){
            TableView.TableViewSelectionModel selectionModel = TabViewFilm.getSelectionModel();
        }
    }


    public void LoadData(Event event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Film> LF = new ArrayList<>();
        LF =FC.TousLesFilms();
        for (Film F: LF) {
            ObList.add(F);
        }
        TitreC.setCellValueFactory(new PropertyValueFactory<>("titre"));
        NomRealisateurC.setCellValueFactory(new PropertyValueFactory<>("NomRealisateur"));
        AnneeC.setCellValueFactory(new PropertyValueFactory<>("AnneeRealisation"));
        DescriptionS.setCellValueFactory(new PropertyValueFactory<>("description"));
        System.out.println(ObList.size());
        for(int i=0;i<ObList.size();i++){
            System.out.println(ObList.get(i));
        }
        TabViewFilm.setItems(ObList);
    }

    public void Delete(ActionEvent actionEvent) {
        try {
            if(FC.SupprimerFilm(TabViewFilm.getSelectionModel().getSelectedItem().getTitre())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Dialogue");
                alert.setHeaderText("Attention");
                alert.setContentText("Mot de passe ou CIN vide !");
                alert.showAndWait();
                TabViewFilm.getItems().removeAll(TabViewFilm.getSelectionModel().getSelectedItem());
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Dialogue");
                alert.setHeaderText("Attention");
                alert.setContentText("le film est associé a une Seance ! ");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }
}
