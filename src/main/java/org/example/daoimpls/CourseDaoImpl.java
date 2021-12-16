package org.example.daoimpls;

import org.example.App;
import org.example.daos.CourseDao;
import org.example.entities.Course;

import javax.persistence.*;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("administration");
    EntityManager em = emf.createEntityManager();
    App app = new App();

    void commit() {
        em.getTransaction().commit();
    }

    void begin() {
        em.getTransaction().begin();
    }

    public CourseDaoImpl() {
    }

    @Override
    public void add(Course course) {
        begin();
        em.persist(course);
        commit();
    }

    @Override
    public void update(Course course) {
        begin();
        em.merge(course);
        commit();
    }

    @Override
    public void remove(Course course) {
        begin();
        em.remove(course);
        commit();
    }

    @Override
    public List<Course> showSpecificInfo(int id) {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE courseId = :id", Course.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Course> showAll() {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
        return query.getResultList();
    }

    @Override
    public Course getById(String question) {
        int id = app.verifyInteger(question);
        return em.find(Course.class, id);
    }

    public void numberOfCoursesInSchool() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Course c", Long.class);
        System.out.println("Antal kurser i skolan: " + query.getResultList());
    }

    public void numberOfCoursesInProgramme(int programmeId) {
        Query query = em.createNativeQuery("SELECT COUNT(courseList_courseId) FROM programme_course " +
                                           "WHERE Programme_programmeId = :programmeId");
        query.setParameter("programmeId", programmeId);
        System.out.println("Antal kurser i program " + programmeId + " är: " + query.getResultList());
    }
}
