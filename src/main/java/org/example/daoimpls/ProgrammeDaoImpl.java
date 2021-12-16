package org.example.daoimpls;

import org.example.App;
import org.example.daos.ProgrammeDao;
import org.example.entities.Programme;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProgrammeDaoImpl implements ProgrammeDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("administration");
    EntityManager em = emf.createEntityManager();
    App app = new App();

    void commit() {
        em.getTransaction().commit();
    }

    void begin() {
        em.getTransaction().begin();
    }

    public ProgrammeDaoImpl() {
    }

    @Override
    public void add(Programme programme) {
        begin();
        em.persist(programme);
        commit();
    }

    @Override
    public void update(Programme programme) {
        begin();
        em.merge(programme);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Programme programme) {
        begin();
        em.remove(programme);
        commit();
    }

    @Override
    public List<Programme> showSpecificInfo(int id) {
        TypedQuery<Programme> query = em.createQuery("SELECT p FROM Programme p WHERE programmeId = :id", Programme.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Programme> showAll() {
        TypedQuery<Programme> query = em.createQuery("SELECT p FROM Programme p", Programme.class);
        return query.getResultList();
    }

    @Override
    public Programme getById(String question) {
        int id = app.verifyInteger(question);
        return em.find(Programme.class, id);
    }

    @Override
    public void numberOfProgrammesInSchool() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Programme p", Long.class);
        System.out.println("Antal program i skolan: " + query.getResultList());
    }
}
