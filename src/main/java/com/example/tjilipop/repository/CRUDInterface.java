package com.example.tjilipop.repository;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CRUDInterface<T> {
    //Create in database
    public boolean insert(T entity);

    //Read from database
    public T getSingleEntity(@RequestParam(required = false) int id);
    public List<T> getList(String dbTable);

    //Update database
    public boolean update(T entity);

    //Delete in database
    public boolean delete(int id);
}
