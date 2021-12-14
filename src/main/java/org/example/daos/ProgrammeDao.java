package org.example.daos;

import org.example.App;
import org.example.Programme;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProgrammeDao implements MainDao<Programme> {
    Manager m;
    App app;

    public ProgrammeDao() {
        m = new Manager();
        app = new App();
    }

    @Override
    public void add(Programme programme) {
        m.em.getTransaction().begin();
        m.em.persist(programme);
        m.em.getTransaction().commit();
    }

    @Override
    public void update(Programme programme) {
        m.em.getTransaction().begin();
        m.em.merge(programme);
        m.em.getTransaction().commit();
    }

    @Override
    public void remove(Programme programme) {
        m.em.getTransaction().begin();
        m.em.remove(programme);
        m.em.getTransaction().commit();
    }

    @Override
    public List<Programme> showSpecificInfo(int id) {
        TypedQuery<Programme> query = m.em.createQuery("SELECT p FROM Programme p WHERE programmeId = :id", Programme.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Programme> showAll() {
        TypedQuery<Programme> query = m.em.createQuery("SELECT p FROM Programme p", Programme.class);
        return query.getResultList();
    }

    @Override
    public Programme getById(String question) {
        int id = app.verifyInteger(question);
        return m.em.find(Programme.class, id);
    }
}
