package org.example.DAO;

import org.example.bibliotecafx.HibernateUtil;
import org.example.entities.autor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class autorDAO implements ItfAutor{

    // Método para añadir un nuevo autor
    public void anyadirAutor(autor autor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(autor); // Guarda el autor en la base de datos
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }



    // Método para modificar un autor existente
    public void modificarAutor(autor autor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(autor); // Actualiza el autor en la base de datos
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para eliminar un autor
    public void eliminarAutor(String idAutor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            autor autor = session.get(autor.class, idAutor); // Busca el autor por su ID
            if (autor != null) {
                session.remove(autor); // Elimina el autor de la base de datos
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<autor> autoresPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<autor> listarAutores() {
        return null;
    }

    // Método para buscar autores por nombre
    public List<autor> buscarAutoresPorNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<autor> query = session.createQuery(
                    "FROM autor WHERE nombre LIKE :nombre", autor.class);
            query.setParameter("nombre", "%" + nombre + "%"); // Búsqueda parcial
            return query.getResultList(); // Retorna la lista de autores encontrados
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para listar todos los autores
    public List<autor> listarTodosLosAutores() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<autor> query = session.createQuery("FROM autor", autor.class);
            return query.getResultList(); // Retorna la lista de todos los autores
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
