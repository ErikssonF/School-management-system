package org.example.daos;

import org.example.Programme;

interface MainDao {
    public void addProgramme(Programme programme);
    public void updateProgramme(Programme programme);
    public void showProgrammeInfo(int id);
}
