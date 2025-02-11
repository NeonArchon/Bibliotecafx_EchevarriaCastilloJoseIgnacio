package org.example;

import org.example.bibliotecafx.HibernateUtil;
import org.example.entities.*;

import org.example.DAO.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class main {

    public static void main(String[] args) {

        /*        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession(); +*/

        libroDAO libroDAO = new libroDAO();
        socioDAO socioDAO = new socioDAO();
        prestamoDAO prestamoDAO = new prestamoDAO();

        // Prueba de LibroDAO
        System.out.println("=== Pruebas de LibroDAO ===");
        libro libro1 = new libro();
        libro1.setTitulo("Cien años de soledad");
        libro1.setIsbn("978-0307474728");
        libro1.setEditorial("Penguin Random House");
        libro1.setAnioPublicacion(1967);
        libro1.setPrestado(false);


        libroDAO.anyaadirLibro(libro1);
        System.out.println("Libro agregado: " + libro1.getTitulo());

        // Prueba de SocioDAO
        System.out.println("\n=== Pruebas de SocioDAO ===");
        socio socio1 = new socio();
        socio1.setNombre("Juan Pérez");
        socio1.setTelefono("123456789");

        socioDAO.agregarSocio(socio1);
        System.out.println("Socio agregado: " + socio1.getNombre());

        // Listar préstamos actuales
        System.out.println("\n=== Préstamos actuales ===");
        prestamoDAO.HistorialPrestamosActuales().forEach(p -> {
            System.out.println("Libro: " + p.getLibro().getTitulo() + ", Socio: " + p.getSocio().getNombre());
        });

        // Listar historial de préstamos de un socio
        System.out.println("\n=== Historial de préstamos del socio ===");
        prestamoDAO.HistorialPrestamosSocio(socio1.getId()).forEach(p -> {
            System.out.println("Libro: " + p.getLibro().getTitulo() + ", Fecha préstamo: " + p.getFechaPrestamo());
        });

    }

}
