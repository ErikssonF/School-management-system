package org.example.daos;

import org.example.entities.Course;

import java.util.List;

public interface CourseDao {
    void add(Course course);
    void update(Course course);
    void remove(Course course);
    Course getById(String question);

    List<Course> showSpecificInfo(int id);
    List<Course> showAll();
    void numberOfCoursesInSchool();
    void numberOfCoursesInProgramme(int programmeId);
}