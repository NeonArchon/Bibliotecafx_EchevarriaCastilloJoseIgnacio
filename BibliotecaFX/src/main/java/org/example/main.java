package org.example;

import org.example.bibliotecafx.HibernateUtil;
import org.example.entities.*;

import org.example.DAO.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class main {

    public static void main(String[] args) {
        libroDAO libroDAO = new libroDAO();
        autorDAO autorDAO = new autorDAO();

        // Crear un autor
        autor autor = new autor();
        autor.setNombre("Gabriel García Márquez");
        autorDAO.anyadirAutor(autor); // Guardar el autor en la base de datos

        // Crear un libro y asignarle el autor
        libro libro = new libro();
        libro.setTitulo("Cien años de soledad");
        libro.setIsbn("978-0307474728");
        libro.setEditorial("Penguin Random House");
        libro.setAnioPublicacion(1967);
        libro.setPrestado(false);
        libro.setAutor(autor); // Asignar el autor al libro

        // Guardar el libro
        libroDAO.anyaadirLibro(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());

    }

}
