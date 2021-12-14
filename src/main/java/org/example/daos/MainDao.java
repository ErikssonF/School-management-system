package org.example.daos;

import java.util.List;

public interface MainDao<T> {
    void add(T t);
    void update(T t);
    void remove(T t);
    List<T> showSpecificInfo(int id);
    List<T> showAll();
    T getById(String question);
}