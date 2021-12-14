package org.example.daos;

import org.example.Student;

import java.util.List;

public class StudentDao implements MainDao<Student> {
    Manager m;

    StudentDao() {
        m = new Manager();
    }

    @Override
    public void add(Student student) {
        m.em.getTransaction().begin();
        m.em.persist(student);
        m.em.getTransaction().commit();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void remove(Student student) {

    }

    @Override
    public List<Student> showSpecificInfo(int id) {
        return null;
    }

    @Override
    public List<Student> showAll() {
        return null;
    }

}
