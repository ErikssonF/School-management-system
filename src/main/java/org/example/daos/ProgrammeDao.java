package org.example.daos;

import org.example.entities.Programme;

import java.util.List;

public interface ProgrammeDao {
    void add(Programme programme);
    void update(Programme programme);
    void remove(Programme programme);
    Programme getById(String question);

    List<Programme> showSpecificInfo(int id);
    List<Programme> showAll();
    void numberOfProgrammesInSchool();
}
