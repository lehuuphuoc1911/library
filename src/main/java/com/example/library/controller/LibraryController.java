package com.example.library.controller;


import com.example.library.entity.Book;
import com.example.library.entity.Library;
import com.example.library.service.BookService;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Library add(@RequestBody Library library){
        return libraryService.add(library);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Library get(@Param("id") int id){
        return libraryService.getById(id);
    }

    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public List<Library> getAll(){
        return libraryService.getAll();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public void delete(@Param("id") int id){
        libraryService.delete(id);
    }

    @RequestMapping(path = "/{id}/getAllBook")
    public  List<Book> getAllBook(@PathVariable("id") int id){
        return bookService.getAllBookInLibrary(id);
    }
}
