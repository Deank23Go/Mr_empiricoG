package com.empirico.repository;

import com.empirico.Model.Mantenimiento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MantenimientoRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mantenimientoPU");

    public List<Mantenimiento> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT m FROM Mantenimiento m", Mantenimiento.class).getResultList();
    }

    public Mantenimiento save(Mantenimiento mantenimiento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(mantenimiento);
        em.getTransaction().commit();
        em.close();
        return mantenimiento;
    }
}
