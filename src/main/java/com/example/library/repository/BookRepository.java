package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer> {
    @Query(value = "SELECT book.id, title, author_id, library_id FROM book join library on book.library_id = library.id WHERE library.id = ?1 ;", nativeQuery = true)
    List<Book> getAllBookInLibrary(int id);

    @Query(value = "SELECT book.id, title, author_id, library_id FROM book join author on book.author_id = author.id WHERE author.id = ?1 ;", nativeQuery = true)
    List<Book> getAllBookOfAuthor(int id);
}
