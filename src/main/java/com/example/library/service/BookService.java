package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookService(){};

    public Book add(Book author){
        return bookRepository.save(author);
    }

    public List<Book> getAll(){
        List<Book> list = new ArrayList<>();
        for (Book book : bookRepository.findAll()
        ) {
            list.add(book);
        }
        return list;
    }

    public Book getById(int id){
        return bookRepository.findById(id).get();
    }

    public void delete(int id){
        bookRepository.deleteById(id);
    }
}
