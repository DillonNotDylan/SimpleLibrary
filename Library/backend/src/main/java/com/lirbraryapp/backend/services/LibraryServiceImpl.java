package com.lirbraryapp.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lirbraryapp.backend.dataTransferObjects.BookInfo;
import com.lirbraryapp.backend.dataTransferObjects.LibraryRequest;
import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
import com.lirbraryapp.backend.entity.Book;
import com.lirbraryapp.backend.repository.BookRepository;
import com.lirbraryapp.backend.utils.LibraryUtils;

@Service
public class LibraryServiceImpl implements LibraryServices {

    @Autowired
    BookRepository bookRepository;


    // GET ALL BOOKS IN DATABASE
    public LibraryResponse getAllBooks() {
        // Step 1: Retrieve all books from the database
        List<Book> allBooks = bookRepository.findAll();

        // Step 2: Check if books are found
        if (allBooks.isEmpty()) {
            return LibraryResponse.builder()
                .responseCode(LibraryUtils.BOOKS_NOT_FOUND_CODE)
                .responseMessage(LibraryUtils.BOOKS_NOT_FOUND_MESSAGE)
                .build();
        }

        // Step 3: Map the books to a list of BookInfo objects
        List<BookInfo> bookInfoList = new ArrayList<>();
        for (Book book : allBooks) {
            BookInfo bookInfo = BookInfo.builder()
                .isbn(book.getIsbn())
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .rating(book.getRating())
                .datePublished(book.getDatePublished())
                .checkedIn(book.getCheckedOut())
                .checkedOutTo(book.getCheckedOutTo())
                .dateRented(book.getDateRented())
                .dueDate(book.getDueDate())
                .imageUrl(book.getImageUrl())
                .build();
            bookInfoList.add(bookInfo);
        }

        // Step 4: Return the response with all books
        return LibraryResponse.builder()
            .responseCode(LibraryUtils.BOOKS_FOUND_CODE)
            .responseMessage(LibraryUtils.BOOKS_FOUND_MESSAGE)
            .bookList(bookInfoList)
            .build();
    }


    // USER SEARCH CRITERIA TO FIND BOOKS
    public LibraryResponse searchForBook(LibraryRequest libraryRequest) {
        // Start with a query that returns all books
        List<Book> filteredBooks = bookRepository.findAll();

        // Apply filters based on the fields in the LibraryRequest
        if (libraryRequest.getBookISBN() != null && !libraryRequest.getBookISBN().isEmpty()) {
            filteredBooks = filteredBooks.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(libraryRequest.getBookISBN()))
                .collect(Collectors.toList());
        }

        if (libraryRequest.getBookName() != null && !libraryRequest.getBookName().isEmpty()) {
            filteredBooks = filteredBooks.stream()
                .filter(book -> book.getBookName().equalsIgnoreCase(libraryRequest.getBookName()))
                .collect(Collectors.toList());
        }

        if (libraryRequest.getBookAuthor() != null && !libraryRequest.getBookAuthor().isEmpty()) {
            filteredBooks = filteredBooks.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(libraryRequest.getBookAuthor()))
                .collect(Collectors.toList());
        }

        if (libraryRequest.getBookGenre() != null && !libraryRequest.getBookGenre().isEmpty()) {
            filteredBooks = filteredBooks.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(libraryRequest.getBookGenre()))
                .collect(Collectors.toList());
        }

        if (libraryRequest.getDateRented() != null) {
            filteredBooks = filteredBooks.stream()
                .filter(book -> book.getDatePublished().equals(libraryRequest.getDateRented()))
                .collect(Collectors.toList());
        }

        if (libraryRequest.getCheckedOut() != null) {
            filteredBooks = filteredBooks.stream()
                .filter(book -> book.getCheckedOut().equals(libraryRequest.getCheckedOut()))
                .collect(Collectors.toList());
        }

        // Return a response if no books were found
        if (filteredBooks.isEmpty()) {
            return LibraryResponse.builder()
                .responseCode(LibraryUtils.BOOKS_NOT_FOUND_CODE)
                .responseMessage(LibraryUtils.BOOKS_NOT_FOUND_MESSAGE)
                .build();
        }

        // Map the filtered books to BookInfo objects
        List<LibraryRequest> bookInfoList = filteredBooks.stream()
            .map(book -> LibraryRequest.builder()
                .bookISBN(book.getIsbn())
                .bookName(book.getBookName())
                .bookAuthor(book.getAuthor())
                .bookGenre(book.getGenre())
                .bookRating(book.getRating())
                .bookPublishedDate(book.getDatePublished())
                .checkedOut(book.getCheckedOut())
                .checkedOutTo(book.getCheckedOutTo())
                .dateRented(book.getDateRented())
                .dueDate(book.getDueDate())
                .bookImage(book.getImageUrl())
                .build())
            .collect(Collectors.toList());

        // Return the response with filtered books
        return LibraryResponse.builder()
            .responseCode(LibraryUtils.BOOKS_FOUND_CODE)
            .responseMessage(LibraryUtils.BOOKS_FOUND_MESSAGE)
            .bookList(bookInfoList)
            .build();
    }
}
