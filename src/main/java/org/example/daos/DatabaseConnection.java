package org.example.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnection {
    EntityManagerFactory emf;
    EntityManager em;

    public DatabaseConnection() {
        emf = Persistence.createEntityManagerFactory("administration");
        em = emf.createEntityManager();
    }

    void commit() {
        em.getTransaction().commit();
    }

    void begin() {
        em.getTransaction().begin();
    }
}
