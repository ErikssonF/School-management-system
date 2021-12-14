package org.example.daos;

public class StudentDao implements MainDao {
    Manager m;

    StudentDao() {
        m = new Manager();
    }
}
