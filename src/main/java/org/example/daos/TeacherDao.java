package org.example.daos;

import org.example.App;
import org.example.Teacher;

import javax.persistence.TypedQuery;
import java.util.List;

public class TeacherDao implements MainDao<Teacher> {
    DatabaseConnection dc = new DatabaseConnection();
    App app = new App();

    public TeacherDao() {
    }

    @Override
    public void add(Teacher teacher) {
        dc.em.getTransaction().begin();
        dc.em.persist(teacher);
        dc.em.getTransaction().commit();
    }

    @Override
    public void update(Teacher teacher) {
        dc.em.getTransaction().begin();
        dc.em.merge(teacher);
        dc.em.getTransaction().commit();
    }

    @Override
    public void remove(Teacher teacher) {
        dc.em.getTransaction().begin();
        dc.em.remove(teacher);
        dc.em.getTransaction().commit();
    }

    @Override
    public List<Teacher> showSpecificInfo(int id) {
        TypedQuery<Teacher> query = dc.em.createQuery("SELECT t FROM Teacher t WHERE teacherId = :id", Teacher.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Teacher> showAll() {
        TypedQuery<Teacher> query = dc.em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return query.getResultList();
    }

    @Override
    public Teacher getById(String question) {
        int id = app.verifyInteger(question);
        return dc.em.find(Teacher.class, id);
    }

    public void numberOTeachersInSchool(){
        TypedQuery<Long> query = dc.em.createQuery("SELECT COUNT(t) FROM Teacher t", Long.class);
        System.out.println("Antal lärare i skolan är: " + query.getResultList());
    }

    public void numberOfTeachersInProgramme(int courseId){
        TypedQuery<Long> query = dc.em.createQuery("SELECT COUNT(t) FROM Teacher t WHERE t.courseId = :courseId", Long.class);
        query.setParameter("courseId", courseId);
        System.out.println("Antal lärare i program " + courseId + " är: " + query.getResultList());
    }
}
