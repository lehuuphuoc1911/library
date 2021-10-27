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

    @Autowired
    AuthorService authorService;

    @Autowired
    LibraryService libraryService;

    public BookService(){};

    public Book add(Book book){
        try{
            book.setAuthor(authorService.getById(book.getAuthor().getId()));
        } catch (Exception e){
            System.out.println("invalid author id");
        }
        try{
            book.setLibrary(libraryService.getById(book.getLibrary().getId()));
        } catch (Exception e){
            System.out.println("invalid library id");
        }
        return bookRepository.save(book);
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

    public List<Book> getAllBookInLibrary(int id){
        return bookRepository.getAllBookInLibrary(id);
    }

    public List<Book> getAllBookOfAuthor(int id){
        return bookRepository.getAllBookOfAuthor(id);
    }
}
