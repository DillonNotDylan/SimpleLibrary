package com.lirbraryapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lirbraryapp.backend.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // This method will retrieve all books from the books table
    List<Book> findAll();

    // Optionally, add more custom queries if needed
    // Example: Find books by genre
    List<Book> findByGenre(String genre);

    // Example: Find a book by ISBN
    Book findByIsbn(String isbn);
}
