package org.example.DAO;

import org.example.bibliotecafx.HibernateUtil;
import org.example.entities.libro;
import org.example.entities.socio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import jakarta.persistence.EntityManager;
import java.util.List;

public class socioDAO implements itfSocio{

    @Override
    public void agregarSocio(socio socio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(socio); // Usamos save() en lugar de persist()
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void modificarSocio(socio socio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(socio); // Usamos update() en lugar de merge()
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarSocio(Long idSocio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            socio socio = session.get(socio.class, idSocio);
            if (socio != null) {
                session.delete(socio); // Usamos delete() en lugar de remove()
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
    public socio socioPorNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<socio> query = session.createQuery("FROM socio WHERE nombre = :nombre", socio.class);
            query.setParameter("nombre", nombre);
            return query.uniqueResult(); // Usamos uniqueResult() en lugar de getSingleResult()
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public socio socioPorTelefono(String telefono) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<socio> query = session.createQuery("FROM socio WHERE telefono = :telefono", socio.class);
            query.setParameter("telefono", telefono);
            return query.uniqueResult(); // Usamos uniqueResult() en lugar de getSingleResult()
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<socio> listarSocios() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<socio> query = session.createQuery("FROM socio", socio.class);
            return query.list(); // Usamos list() en lugar de getResultList()
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
