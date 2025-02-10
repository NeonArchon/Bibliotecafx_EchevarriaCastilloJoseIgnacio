package org.example.DAO;

import org.example.entities.autor;
import org.hibernate.mapping.List;

public interface ItfAutor {

    void añadirAutor(autor autor);
    void modificarAutor(autor autor);
    boolean eliminarAutor(Long idAutor);
    List<autor> buscarAutoresPorNombre(String nombre);
    List<autor> listarTodosLosAutores();

}
