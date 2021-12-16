package org.example.daoimpls;

import org.example.App;
import org.example.daos.TeacherDao;
import org.example.entities.Teacher;

import javax.persistence.*;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("administration");
    EntityManager em = emf.createEntityManager();
    App app = new App();

    void commit() {
        em.getTransaction().commit();
    }

    void begin() {
        em.getTransaction().begin();
    }

    public TeacherDaoImpl() {
    }

    @Override
    public void add(Teacher teacher) {
        begin();
        em.persist(teacher);
        commit();
    }

    @Override
    public void update(Teacher teacher) {
        begin();
        em.merge(teacher);
        commit();
    }

    @Override
    public void remove(Teacher teacher) {
        begin();
        em.remove(teacher);
        commit();
    }

    @Override
    public List<Teacher> showSpecificInfo(int id) {
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t WHERE teacherId = :id", Teacher.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Teacher> showAll() {
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return query.getResultList();
    }

    @Override
    public Teacher getById(String question) {
        int id = app.verifyInteger(question);
        return em.find(Teacher.class, id);
    }

    @Override
    public void numberOfTeachersInSchool(){
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(t) FROM Teacher t", Long.class);
        System.out.println("Antal lärare i skolan är: " + query.getResultList());
    }

    @Override
    public void numberOfTeachersInCourse(int courseId){
        Query query = em.createNativeQuery("SELECT COUNT(teacherList_teacherId) FROM course_teacher " +
                                           "WHERE Course_courseId = :courseId");
        query.setParameter("courseId", courseId);
        System.out.println("Antal lärare i program " + courseId + " är: " + query.getResultList());
    }
}
