package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.Library;
import com.example.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public LibraryService(){

    }

    public Library add(Library library){
        return libraryRepository.save(library);
    }

    public List<Library> getAll(){
        List<Library> list = new ArrayList<>();
        for (Library library : libraryRepository.findAll()
        ) {
            list.add(library);
        }
        return list;
    }

    public Library getById(int id){
        return libraryRepository.findById(id).get();
    }

    public void delete(int id){
        libraryRepository.deleteById(id);
    }

}
