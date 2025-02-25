package com.lirbraryapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lirbraryapp.backend.entity.Books;

public interface RentRepository extends JpaRepository<Books, String>{
}