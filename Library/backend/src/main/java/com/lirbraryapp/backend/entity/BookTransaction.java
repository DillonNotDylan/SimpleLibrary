package com.lirbraryapp.backend.entity;

import com.lirbraryapp.backend.model.TransactionType;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Getter/Setter from lombok allows for manipulation of private variables 
 * without having to create custom Getter/Setter methods
 */
@Getter
@Setter

/**
 * Creates constructors for us
 */
@NoArgsConstructor
@AllArgsConstructor


@Builder
@Entity
@Table(name = "book_transaction")
public class BookTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "transaction_type")
    private String transactionType; // Enum for 'CHECK_OUT' or 'CHECK_IN'

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "returned_date")
    private LocalDate returnedDate;
}
