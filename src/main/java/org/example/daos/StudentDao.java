package org.example.daos;

import org.example.App;
import org.example.Student;

import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDao implements MainDao<Student> {
    Manager m;
    App app;

    public StudentDao() {
        m = new Manager();
        app = new App();
    }

    @Override
    public void add(Student student) {
        m.em.getTransaction().begin();
        m.em.persist(student);
        m.em.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        m.em.getTransaction().begin();
        m.em.merge(student);
        m.em.getTransaction().commit();
    }

    @Override
    public void remove(Student student) {
        m.em.getTransaction().begin();
        m.em.remove(student);
        m.em.getTransaction().commit();
    }

    @Override
    public List<Student> showSpecificInfo(int id) {
        TypedQuery<Student> query = m.em.createQuery("SELECT s FROM Student s WHERE studentId = :id", Student.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Student> showAll() {
        TypedQuery<Student> query = m.em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student getById(String question) {
        int id = app.verifyInteger(question);
        return m.em.find(Student.class, id);
    }

}
