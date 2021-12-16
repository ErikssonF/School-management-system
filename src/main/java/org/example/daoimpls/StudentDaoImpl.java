package org.example.daoimpls;

import org.example.App;
import org.example.daos.StudentDao;
import org.example.entities.Student;

import javax.persistence.*;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("administration");
    EntityManager em = emf.createEntityManager();
    App app = new App();

    void commit() {
        em.getTransaction().commit();
    }

    void begin() {
        em.getTransaction().begin();
    }

    public StudentDaoImpl() {
    }

    @Override
    public void add(Student student) {
        begin();
        em.persist(student);
        commit();
    }

    @Override
    public void update(Student student) {
        begin();
        em.merge(student);
        commit();
    }

    @Override
    public void remove(Student student) {
        begin();
        em.remove(student);
        commit();
    }

    @Override
    public List<Student> showSpecificInfo(int id) {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE studentId = :id", Student.class);
        return query.setParameter("id", id).getResultList();
    }

    @Override
    public List<Student> showAll() {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student getById(String question) {
        int id = app.verifyInteger(question);
        return em.find(Student.class, id);
    }

    @Override
    public void numberOfStudentsInSchool() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(s) FROM Student s", Long.class);
        System.out.println("Antal elever i skolan: " + query.getResultList());
    }

    @Override
    public void numberOfStudentsInProgramme(int programmeId) {
        Query query = em.createNativeQuery("SELECT COUNT(studentList_studentId) FROM programme_student " +
                                          "WHERE Programme_programmeId = :programmeId");
        query.setParameter("programmeId", programmeId);
        System.out.println("Antal elever i program " + programmeId + " är: " + query.getResultList());
    }
}
