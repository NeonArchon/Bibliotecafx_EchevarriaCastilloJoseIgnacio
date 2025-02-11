package org.example.DAO;

import org.example.bibliotecafx.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.entities.libro;
import org.hibernate.query.Query;
import java.util.List;


public class libroDAO implements ItfLibro{

    @Override
    public void anyaadirLibro(libro libro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void modificarLibro(libro libro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarLibro(Long idLibro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            libro libro = session.get(libro.class, idLibro);
            if (libro != null) {
                session.delete(libro);
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
    public libro libroPorTitulo(String titulo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<libro> query = session.createQuery("FROM libro WHERE titulo = :titulo", libro.class);
            query.setParameter("titulo", titulo);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public libro libroPorAutor(String autor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<libro> query = session.createQuery("FROM libro WHERE autor.nombre = :autor", libro.class);
            query.setParameter("autor", autor);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public libro libroPorISBN(String isbn) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<libro> query = session.createQuery("FROM libro WHERE isbn = :isbn", libro.class);
            query.setParameter("isbn", isbn);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<libro> librosDisponibles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<libro> query = session.createQuery("FROM libro WHERE prestado = false", libro.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
