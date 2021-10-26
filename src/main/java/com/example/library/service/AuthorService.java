package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService(){};

    public Author add(Author author){
        return authorRepository.save(author);
    }

    public List<Author> getAll(){
        List<Author> list = new ArrayList<>();
        for (Author author : authorRepository.findAll()
        ) {
            list.add(author);
        }
        return list;
    }

    public Author getById(int id){
        return authorRepository.findById(id).get();
    }

    public void delete(int id){
        authorRepository.deleteById(id);
    }
}


