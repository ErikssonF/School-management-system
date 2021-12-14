package org.example.daos;

import org.example.Student;
import org.example.Teacher;

import javax.persistence.TypedQuery;
import java.util.List;

public class TeacherDao implements MainDao<Teacher> {
    Manager m;

    public TeacherDao() {
        m = new Manager();
    }

    @Override
    public void add(Teacher teacher) {
        m.em.getTransaction().begin();
        m.em.persist(teacher);
        m.em.getTransaction().commit();
    }

    @Override
    public void update(Teacher teacher) {
        m.em.getTransaction().begin();
        m.em.merge(teacher);
        m.em.getTransaction().commit();
    }

    @Override
    public void remove(Teacher teacher) {
        m.em.getTransaction().begin();
        m.em.remove(teacher);
        m.em.getTransaction().commit();
    }

    @Override
    public List<Teacher> showSpecificInfo(int id) {
        TypedQuery<Teacher> query = m.em.createQuery("SELECT t FROM Teacher t WHERE teacherId = :id", Teacher.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Teacher> showAll() {
        TypedQuery<Teacher> query = m.em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return query.getResultList();
    }
}
