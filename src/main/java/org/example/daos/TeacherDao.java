package org.example.daos;

public class TeacherDao implements MainDao {
    Manager m;

    TeacherDao() {
        m = new Manager();
    }
}
