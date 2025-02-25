package com.lirbraryapp.backend.services;

import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
import com.lirbraryapp.backend.dataTransferObjects.UserRequest;

public interface UserServices {
    LibraryResponse createAccount(UserRequest userRequest);
    LibraryResponse accountAuthorized(UserRequest userRequest);
    LibraryResponse rentBook(UserRequest userRequest);
    LibraryResponse returnBook(UserRequest userRequest);
}
