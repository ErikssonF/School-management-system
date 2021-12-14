package org.example.daos;

public class CourseDao implements MainDao {
    Manager m;

    CourseDao() {
        m = new Manager();
    }
}
