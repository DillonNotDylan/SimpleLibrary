package com.lirbraryapp.backend.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import jakarta.persistence.Table;

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

@Table(name = "users")
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String email;
    private String password;
    private String state;
    private Integer isActive;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
