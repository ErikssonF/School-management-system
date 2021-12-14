package org.example.daos;

public class ProgrammeDao implements MainDao {
    Manager m;

    ProgrammeDao() {
        m = new Manager();
    }
}
