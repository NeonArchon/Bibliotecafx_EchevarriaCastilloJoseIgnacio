package org.example.bibliotecafx.interfaz;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.example.bibliotecafx.interfaz.AutorControlador;
import org.example.DAO.autorDAO;
import org.example.entities.autor;

public class AutorControlador extends Application {

    @FXML
    private Button agregarAutorButton;

    @FXML
    private Button modificarAutorButton;

    @FXML
    private Button eliminarAutorButton;

    @FXML
    private Button autoresPorNombreButton;

    @FXML
    private Button listarAutoresButton;

    @FXML
    private Button volverButton;

    @FXML
    private TextField idAutorField;

    @FXML
    private TextField nombreAutorField;

    private autorDAO autorDAO; // Instancia de autorDAO

    public AutorControlador() {
        this.autorDAO = new autorDAO(); // Inicializa la instancia
    }

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
        idAutorField.clear();
        nombreAutorField.clear();
    }

    // Método para agregar un autor
    @FXML
    private void accionAgregarAutor() {
        String nombre = nombreAutorField.getText();
        if (nombre.isEmpty()) {
            mostrarAlerta("Error", "El nombre del autor no puede estar vacío.");
            return;
        }

        autor autor = new autor();
        autor.setNombre(nombre);

        autorDAO.anyadirAutor(autor);
        mostrarAlerta("Éxito", "Autor agregado correctamente.");
        limpiarCampos();
    }

    // Método para modificar un autor
    @FXML
    private void handleModificarAutor() {
        String id = idAutorField.getText();
        String nombre = nombreAutorField.getText();

        if (id.isEmpty() || nombre.isEmpty()) {
            mostrarAlerta("Error", "El ID y el nombre del autor no pueden estar vacíos.");
            return;
        }

        autor autor = new autor();
        autor.setId(Long.valueOf(id));
        autor.setNombre(nombre);

        autorDAO.modificarAutor(autor);
        mostrarAlerta("Éxito", "Autor modificado correctamente.");
        limpiarCampos();
    }

    @Override
    public void start(Stage stage) throws Exception {





    }
}
