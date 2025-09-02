package com.empirico.repository;

import com.empirico.Model.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class EquipoRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mantenimientoPU");

    public List<Equipo> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT e FROM Equipo e", Equipo.class).getResultList();
    }

    public Equipo save(Equipo equipo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(equipo);
        em.getTransaction().commit();
        em.close();
        return equipo;
    }
}
