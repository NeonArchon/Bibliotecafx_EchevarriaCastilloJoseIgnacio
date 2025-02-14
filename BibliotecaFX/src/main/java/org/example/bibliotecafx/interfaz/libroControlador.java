package org.example.bibliotecafx.interfaz;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.example.entities.autor;
import org.example.entities.libro;
import org.example.DAO.libroDAO;
import org.example.DAO.autorDAO;

public class libroControlador extends Application {

    @FXML
    private Button agregarLibroButton;

    @FXML
    private Button modificarLibroButton;

    @FXML
    private Button eliminarLibroButton;

    @FXML
    private Button librosPorNombreButton;

    @FXML
    private Button listarTelefonoButton;

    @FXML
    private Button volverButton;

    @FXML
    private TextField idLibroField;

    @FXML
    private TextField tituloLibroField;

    @FXML
    private TextField autorLibroField;

    @FXML
    private TextField isbnLibroField;

    private libroDAO libroDAO = new libroDAO();
    private libroDAO autorDAO = new libroDAO();

    // Método para volver a la pantalla principal
    @FXML
    private void handleVolver() {
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Método para limpiar los campos de texto
    private void limpiarCampos() {
        idLibroField.clear();
        tituloLibroField.clear();
        autorLibroField.clear();
        isbnLibroField.clear();
    }

    @FXML
    private void accionAgregarLibro(){

        String titulo = tituloLibroField.getText();
        String autor =  autorLibroField.getText();
        String isbn = isbnLibroField.getText();

        if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }

        libro libro = new libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setIsbn(isbn);

        libroDAO.anyaadirLibro(libro);
        mostrarAlerta("Éxito", "Libro agregado correctamente.");
        limpiarCampos();

    }



    @Override
    public void start(Stage stage) throws Exception {



    }
}
