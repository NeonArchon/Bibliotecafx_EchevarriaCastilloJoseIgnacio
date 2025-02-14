package org.example.bibliotecafx.interfaz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/bibliotecafx/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 445, 354);
        stage.setTitle("Gestor de Librería 'Mi Librito'");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    private Button botonSalir;

    @FXML
    private Button botonGestionLibros;

    @FXML
    private Button botonGestionAutores;

    @FXML
    private Button botonGestionPrestamos;

    @FXML
    private Button botonGestionSocios;


    @FXML
    private void accionBotonSalir(ActionEvent event){

        // Cerrar la aplicación
        Stage stage = (Stage) botonSalir.getScene().getWindow();
        stage.close();

    }



    @FXML
    private void accionBotonGestionAutores(ActionEvent event){



    }

    @FXML
    private void accionBotonGestionPrestamos(ActionEvent event){


    }

    @FXML
    private void accionBotonGestionSocios(ActionEvent event){


    }

    public void accionBotonGestionlibros(ActionEvent actionEvent) {


    }

}