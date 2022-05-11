package com.example.tjilipop.repository;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CRUDInterface<T> {
    //Create
    public boolean insert(T entity);

    //Read
    public T getSingleEntity(@RequestParam(required = false) int id);
    public List<T> getList();

    //Update
    public boolean update(T entity);

    //Delete
    public boolean delete(int id);
}
