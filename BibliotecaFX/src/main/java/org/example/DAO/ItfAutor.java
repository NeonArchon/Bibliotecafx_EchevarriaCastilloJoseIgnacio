package org.example.DAO;

import org.example.entities.autor;
import java.util.List;

public interface ItfAutor {

    void anyadirAutor(autor autor);
    void modificarAutor(autor autor);
    void eliminarAutor(String idAutor);
    List<autor> autoresPorNombre(String nombre);
    List<autor> listarAutores();

}
