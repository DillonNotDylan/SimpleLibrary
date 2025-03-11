package com.lirbraryapp.backend.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
import com.lirbraryapp.backend.entity.Book;
import com.lirbraryapp.backend.entity.BookTransaction;
import com.lirbraryapp.backend.entity.User;
import com.lirbraryapp.backend.repository.BookRepository;
import com.lirbraryapp.backend.repository.BookTransactionRepository;
import com.lirbraryapp.backend.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class BookRentalServiceImpl implements BookRentalService {

     @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookTransactionRepository bookTransactionRepository;

    @Transactional
    public LibraryResponse rentBook(String userEmail, Long bookId) {
        // Step 1: Check if the user exists and is active
        User user = userRepository.findByEmail(userEmail);
        if (user == null || user.getIsActive() == 0) {
            return LibraryResponse.builder()
                .responseCode("USER_NOT_ACTIVE")
                .responseMessage("User not found or inactive")
                .build();
        }

        // Step 2: Check if the book exists and is available for checkout
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            return LibraryResponse.builder()
                .responseCode("BOOK_NOT_FOUND")
                .responseMessage("Book not found")
                .build();
        }

        // Check if the book is already checked out
        if (book.getCheckedOut() == 1) {
            return LibraryResponse.builder()
                .responseCode("BOOK_NOT_AVAILABLE")
                .responseMessage("The book is already checked out")
                .build();
        }

        // Step 3: Create a new transaction record for this book checkout
        BookTransaction transaction = new BookTransaction();
        // Assuming transactionTypeString is "CHECK_OUT" or "CHECK_IN"
        transaction.setBookId(book.getId());
        transaction.setUserId(user.getUid());
        transaction.setTransactionType("CHECKED_OUT");
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setDueDate(LocalDate.now().plusDays(14)); // Example: Due in 14 days
        bookTransactionRepository.save(transaction);

        // Step 4: Update the book's status to checked out
        book.setCheckedOut(1); // Mark the book as checked out
        bookRepository.save(book);

        // Step 5: Return success response
        return LibraryResponse.builder()
            .responseCode("SUCCESS")
            .responseMessage("Book successfully rented")
            .build();
    }

    public LibraryResponse returnBook(String userEmail, Long bookId) {
        return null;
    }
    
}
