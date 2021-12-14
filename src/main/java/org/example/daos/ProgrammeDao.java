package org.example.daos;

import org.example.Programme;

import java.util.List;

public class ProgrammeDao implements MainDao<Programme> {
    Manager m;

    ProgrammeDao() {
        m = new Manager();
    }

    @Override
    public void add(Programme programme) {

    }

    @Override
    public void update(Programme programme) {

    }

    @Override
    public void remove(Programme programme) {

    }

    @Override
    public List<Programme> showSpecificInfo(int id) {
        return null;
    }

    @Override
    public List<Programme> showAll() {
        return null;
    }
}
