package com.lirbraryapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lirbraryapp.backend.entity.Book;

public interface RentRepository extends JpaRepository<Book, String>{
}