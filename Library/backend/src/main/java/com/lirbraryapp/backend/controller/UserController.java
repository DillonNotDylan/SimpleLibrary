package com.lirbraryapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
import com.lirbraryapp.backend.dataTransferObjects.UserRequest;
import com.lirbraryapp.backend.services.UserServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

// import org.springframework.web.bind.annotation.GetMapping;


/**
 * Creates an API end point for users to send POST requests to
 */
@RestController
@RequestMapping("/api/user")
@Tag(name = "User Account Management APIs")
public class UserController {

    @Autowired
    UserServices UserService;

    @Operation(
        summary = "Create New User Account",
        description = "Creates a new user and assigns a unique Account Number"
    )
    @ApiResponse(
        responseCode = "201",
        description = "Http Status 201 CREATED"
    )
    @PostMapping
    public LibraryResponse createAccount(@RequestBody UserRequest userRequest) {
        return UserService.createAccount(userRequest);
    }


    
    @Operation(
        summary = "Get authorization status of account",
        description = "Returns 1 if account is authorized, 0 if not"
    )
    @GetMapping("authorized")
    public LibraryResponse accountAuthorized(@RequestBody UserRequest statusRequest) {
        return UserService.accountAuthorized(statusRequest);
    }
    
    @Operation(
        summary = "Get book from library",
        description = "Returns 1 if book was rented, 0 if not"
    )
    @GetMapping("rent")
    public LibraryResponse rentBook(@RequestBody UserRequest rentRequest) {
        return UserService.rentBook(rentRequest);
    }

    @Operation(
        summary = "Return a book to the library",
        description = "Returns 1 if book was returned, 0 if not"
    )
    @PostMapping("return")
    public LibraryResponse returnBook(@RequestBody UserRequest returnRequest) {
        return UserService.returnBook(returnRequest);
    }

}
