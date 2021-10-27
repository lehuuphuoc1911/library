package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Book add(@RequestBody Book book){
        return bookService.add(book);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Book get(@Param("id") int id){
        return bookService.getById(id);
    }

    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public void delete(@Param("id") int id){
        bookService.delete(id);
    }
}
