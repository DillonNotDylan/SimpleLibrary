package com.lirbraryapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
import com.lirbraryapp.backend.dataTransferObjects.RentRequest;
import com.lirbraryapp.backend.services.BookRentalService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/library")
public class BookRentalController {
     @Autowired
    private BookRentalService bookRentalService;

    @PostMapping("/rentBook")
    public LibraryResponse rentBook(@RequestBody RentRequest rentBookRequest) {
        return bookRentalService.rentBook(rentBookRequest.getEmail(), rentBookRequest.getBookId());
    }
}
