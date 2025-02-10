package org.example.DAO;

import org.example.entities.libro;
import org.example.entities.socio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class socioDAO implements itfSocio{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");


    @Override
    public void agregarSocio(socio socio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(socio);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void modificarSocio(socio socio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(socio);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminarSocio(Long idSocio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        socio socio = em.find(socio.class, idSocio);
        if (socio != null) {
            em.remove(socio);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public socio socioPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        socio socio = em.createQuery("SELECT s FROM Socio s WHERE s.nombre = :nombre", socio.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
        em.close();
        return socio;
    }

    @Override
    public socio socioPorTelefono(String telefono) {
        EntityManager em = emf.createEntityManager();
        socio socio = em.createQuery("SELECT s FROM Socio s WHERE s.telefono = :telefono", socio.class)
                .setParameter("nombre", telefono)
                .getSingleResult();
        em.close();
        return socio;
    }

    @Override
    public List<socio> listarSocios() {
        EntityManager em = emf.createEntityManager();
        List<socio> socios = em.createQuery("SELECT s FROM Socio s", socio.class)
                .getResultList();
        em.close();
        return socios;
    }
}
