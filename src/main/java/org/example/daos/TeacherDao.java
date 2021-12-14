package org.example.daos;

import org.example.Teacher;

import java.util.List;

public class TeacherDao implements MainDao<Teacher> {
    Manager m;

    TeacherDao() {
        m = new Manager();
    }

    @Override
    public void add(Teacher teacher) {

    }

    @Override
    public void update(Teacher teacher) {

    }

    @Override
    public void remove(Teacher teacher) {

    }

    @Override
    public List<Teacher> showSpecificInfo(int id) {
        return null;
    }

    @Override
    public List<Teacher> showAll() {
        return null;
    }
}
