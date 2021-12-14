package org.example.daos;

import org.example.Course;

import java.util.List;

public class CourseDao implements MainDao<Course> {
    Manager m;

    CourseDao() {
        m = new Manager();
    }

    @Override
    public void add(Course course) {

    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void remove(Course course) {

    }

    @Override
    public List<Course> showSpecificInfo(int id) {
        return null;
    }

    @Override
    public List<Course> showAll() {
        return null;
    }
}
