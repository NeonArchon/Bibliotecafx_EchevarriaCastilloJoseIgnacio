package org.example.DAO;

import org.example.bibliotecafx.HibernateUtil;
import org.example.entities.prestamo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class prestamoDAO implements itfPrestamo{
    @Override
    public void registrarPrestamo(prestamo prestamo) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(prestamo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<prestamo> HistorialPrestamosActuales() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<prestamo> query = session.createQuery(
                    "SELECT p FROM prestamo p WHERE p.fechaDevolucion IS NULL", prestamo.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<prestamo> HistorialPrestamosSocio(Long idSocio) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<prestamo> query = session.createQuery(
                    "SELECT p FROM prestamo p WHERE p.socio.id = :idSocio", prestamo.class);
            query.setParameter("idSocio", idSocio);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
