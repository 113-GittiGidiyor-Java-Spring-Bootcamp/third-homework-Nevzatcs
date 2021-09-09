package dev.patika.homework03.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    List<T> findAll();
    Optional<T> findById(int id);
    T save(T object);
    void deleteById(int id);
    T updateOnDatabase(T object);
}
