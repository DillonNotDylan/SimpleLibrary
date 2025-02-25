package com.lirbraryapp.backend.entity;

import jakarta.persistence.*;
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

@Table(name = "books")
public class Books {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String BookName;
    private String Author;
    private String Genre;
    private String DatePublished;
    private String checkedIn;
    private String ISBN;
    private String Rating;
    private String CheckedOutTo;
    private String DateRented;
    private String DueDate;
}
