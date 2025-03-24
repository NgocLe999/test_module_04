package org.example.test_module_04.service;

import java.util.List;

public interface IService <T>{

    List<T> getAll();

    void save(T s);

    void update(long id, T s);

    void remove(Long id);

    T findById(long id);

    List<T> findByName(String name);
}
