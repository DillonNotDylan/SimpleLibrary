package com.lirbraryapp.backend.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "book")
@Data // Lombok will generate getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok will generate the no-args constructor
@AllArgsConstructor // Lombok will generate the all-args constructor
@Builder // Lombok will generate a builder pattern for this class
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Auto-incremented primary key

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private double rating;

    @Column(name = "date_published")
    private Date datePublished;

    @Column(name = "checked_in")
    private Integer checkedIn;

    @Column(name = "checked_out_to")
    private String checkedOutTo;

    @Column(name = "date_rented")
    private Date dateRented;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "image_url")
    private String imageUrl;
}

