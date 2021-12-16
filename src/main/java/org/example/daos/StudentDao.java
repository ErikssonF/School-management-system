package org.example.daos;

import org.example.entities.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);
    void update(Student student);
    void remove(Student student);
    Student getById(String question);

    List<Student> showSpecificInfo(int id);
    List<Student> showAll();
    void numberOfStudentsInSchool();
    void numberOfStudentsInProgramme(int programmeId);
}
