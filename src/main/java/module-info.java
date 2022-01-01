module com.example.gestioncinema2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.gestioncinema2 to javafx.fxml;
    exports com.example.gestioncinema2;
    exports com.example.gestioncinema2.Classes;


}