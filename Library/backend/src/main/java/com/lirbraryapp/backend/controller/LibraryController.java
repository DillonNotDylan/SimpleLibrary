package com.lirbraryapp.backend.controller;

// import java.io.FileNotFoundException;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.itextpdf.text.DocumentException;
import com.lirbraryapp.backend.dataTransferObjects.LibraryRequest;
import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
// import com.lirbraryapp.backend.entity.Book;
import com.lirbraryapp.backend.services.LibraryServices;
// import com.lirbraryapp.backend.services.RentStatement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@RequestMapping("/api/library")
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Library Management APIs")
public class LibraryController {

    @Autowired
    LibraryServices LibraryService;
    // private RentStatement rentstatement;


    // @GetMapping("statement")
    // public List<Book> generateRentStatement(@RequestParam String email) throws FileNotFoundException, DocumentException{

    //     return rentstatement.generateStatement(email);
    // }


    @Operation(
        summary = "Gets a list of all the books in the library",
        description = "Returns a list of all the books in the library"
    )
    @GetMapping("allBooks")
    public LibraryResponse allBookResponse() {
        return LibraryService.getAllBooks();
    }


    @Operation(
        summary = "Search for a book in the library or a set of books based on the search criteria",
        description = "Returns a list of books that match the search criteria"
    )
    @PostMapping("/searchBooks")
    public LibraryResponse searchLibraryResponse(@RequestBody LibraryRequest statusRequest) {
        return LibraryService.searchForBook(statusRequest);
    }
}