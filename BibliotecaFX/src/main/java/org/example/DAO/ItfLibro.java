package org.example.DAO;

import org.example.entities.libro;
import java.util.List;

public interface ItfLibro {

    void anyaadirLibro(libro libro);
    void modificarLibro(libro libro);
    void eliminarLibro(Long idLibro);
    libro libroPorTitulo(String titulo);
    libro libroPorAutor(String autor);
    libro libroPorISBN(String isbn);
    List<libro> librosDisponibles();

}
