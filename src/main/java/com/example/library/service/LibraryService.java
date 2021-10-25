package com.example.library.service;

import com.example.library.entity.Library;
import com.example.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public LibraryService(){

    }

    public Library addLibrary(Library library){
        return libraryRepository.save(library);
    }

}
