package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.libro;

import java.util.List;

public class libroDAO implements ItfLibro{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
    @Override
    public void anyaadirLibro(libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificarLibro(libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminarLibro(Long idLibro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        libro libro = em.find(libro.class, idLibro);
        if (libro != null) {
            em.remove(libro);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public libro libroPorTitulo(String titulo) {
        EntityManager em = emf.createEntityManager();
        libro libro = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo", libro.class)
                .setParameter("titulo", titulo)
                .getSingleResult();
        em.close();
        return libro;
    }

    @Override
    public libro libroPorAutor(String autor) {
        EntityManager em = emf.createEntityManager();
        libro libro = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre = :autor", libro.class)
                .setParameter("autor", autor)
                .getSingleResult();
        em.close();
        return libro;
    }

    @Override
    public libro libroPorISBN(String isbn) {
        EntityManager em = emf.createEntityManager();
        libro libro = em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn", libro.class)
                .setParameter("isbn", isbn)
                .getSingleResult();
        em.close();
        return libro;
    }

    @Override
    public List<libro> librosDisponibles() {
        EntityManager em = emf.createEntityManager();
        List<libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.prestado = false", libro.class)
                .getResultList();
        em.close();
        return libros;
    }
}
