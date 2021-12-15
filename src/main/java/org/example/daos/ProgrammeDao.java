package org.example.daos;

import org.example.App;
import org.example.Programme;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProgrammeDao implements MainDao<Programme> {
    DatabaseConnection dc = new DatabaseConnection();
    App app = new App();

    public ProgrammeDao() {
    }

    @Override
    public void add(Programme programme) {
        dc.begin();
        dc.em.persist(programme);
        dc.commit();
    }

    @Override
    public void update(Programme programme) {
        dc.begin();
        dc.em.merge(programme);
        dc.em.getTransaction().commit();
    }

    @Override
    public void remove(Programme programme) {
        dc.begin();
        dc.em.remove(programme);
        dc.commit();
    }

    @Override
    public List<Programme> showSpecificInfo(int id) {
        TypedQuery<Programme> query = dc.em.createQuery("SELECT p FROM Programme p WHERE programmeId = :id", Programme.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Programme> showAll() {
        TypedQuery<Programme> query = dc.em.createQuery("SELECT p FROM Programme p", Programme.class);
        return query.getResultList();
    }

    @Override
    public Programme getById(String question) {
        int id = app.verifyInteger(question);
        return dc.em.find(Programme.class, id);
    }
}
