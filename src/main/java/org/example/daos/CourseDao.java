package org.example.daos;

import org.example.Course;
import org.example.Student;

import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDao implements MainDao<Course> {
    Manager m;

    public CourseDao() {
        m = new Manager();
    }

    @Override
    public void add(Course course) {
        m.em.getTransaction().begin();
        m.em.persist(course);
        m.em.getTransaction().commit();
    }

    @Override
    public void update(Course course) {
        m.em.getTransaction().begin();
        m.em.merge(course);
        m.em.getTransaction().commit();
    }

    @Override
    public void remove(Course course) {
        m.em.getTransaction().begin();
        m.em.remove(course);
        m.em.getTransaction().commit();
    }

    @Override
    public List<Course> showSpecificInfo(int id) {
        TypedQuery<Course> query = m.em.createQuery("SELECT c FROM Course c WHERE courseId = :id", Course.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Course> showAll() {
        TypedQuery<Course> query = m.em.createQuery("SELECT c FROM Course c", Course.class);
        return query.getResultList();
    }
}
