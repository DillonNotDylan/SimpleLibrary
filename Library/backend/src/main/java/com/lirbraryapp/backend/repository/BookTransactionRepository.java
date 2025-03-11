package com.lirbraryapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lirbraryapp.backend.entity.BookTransaction;

public interface BookTransactionRepository extends JpaRepository<BookTransaction, Long>{
    
}
