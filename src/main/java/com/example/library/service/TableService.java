package com.example.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
/*
NOT USING
this code may look cool because it can reduce an amount of codes. but in order to do so, we have to lose Repository layer
and unable to add more queries.

although, if using it the concrete class shall be as below
@Service
public class AddressService extends TableService <Address>{}
 */

public abstract class TableService<T> {
    @Autowired
    private CrudRepository<T,Integer> repo;


    public T add(T entity){
        return repo.save(entity);
    }

    public List<T> getAll(){
        List<T> list = new ArrayList<>();
        for (T entity : repo.findAll()
        ) {
            list.add(entity);
        }
        return list;
    }

    public T getById(int id){
        return repo.findById(id).get();
    }
}
