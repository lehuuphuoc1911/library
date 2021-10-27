package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Author add(@RequestBody Author author){
        return authorService.add(author);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Author get(@Param("id") int id){
        return authorService.getById(id);
    }

    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public List<Author> getAll(){
        return authorService.getAll();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public void delete(@Param("id") int id){
        authorService.delete(id);
    }

    @RequestMapping(path = "/{id}/getAllBook")
    public  List<Book> getAllBook(@PathVariable("id") int id){
        return bookService.getAllBookOfAuthor(id);
    }
}
