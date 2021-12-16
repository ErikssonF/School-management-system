package org.example.daos;

import org.example.entities.Teacher;

import java.util.List;

public interface TeacherDao {
    void add(Teacher teacher);
    void update(Teacher teacher);
    void remove(Teacher teacher);
    Teacher getById(String question);

    List<Teacher> showSpecificInfo(int id);
    List<Teacher> showAll();
    void numberOfTeachersInSchool();
    void numberOfTeachersInCourse(int programmeId);
}
