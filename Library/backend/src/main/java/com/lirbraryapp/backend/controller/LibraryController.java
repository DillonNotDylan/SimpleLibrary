package com.lirbraryapp.backend.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lirbraryapp.backend.entity.Books;
import com.lirbraryapp.backend.services.RentStatement;
import com.itextpdf.text.DocumentException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/booksRented")
@NoArgsConstructor
@AllArgsConstructor
public class LibraryController {

    private RentStatement rentstatement;

    @GetMapping
    public List<Books> generateRentStatement(@RequestParam String email) throws FileNotFoundException, DocumentException{

        return rentstatement.generateStatement(email);
    }
}
