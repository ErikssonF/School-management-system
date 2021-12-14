package org.example.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    EntityManagerFactory emf;
    EntityManager em;

    public Manager() {
        emf = Persistence.createEntityManagerFactory("administration");
        em = emf.createEntityManager();
    }
}
