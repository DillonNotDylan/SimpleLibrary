package com.lirbraryapp.backend.services;

import com.lirbraryapp.backend.entity.Book;
import com.lirbraryapp.backend.repository.RentRepository;

import java.util.List;

import java.io.FileNotFoundException;
import com.itextpdf.text.DocumentException;

public class RentStatement {

    private RentRepository rentRepository;

    public List<Book> generateStatement(String email) throws FileNotFoundException, DocumentException {
    
        List<Book> rentList = rentRepository.findAll().stream()
            .filter(transaction -> transaction.getCheckedOutTo().equals(email))
            .toList();
        return rentList;

    }
}
