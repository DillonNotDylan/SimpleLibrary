package com.lirbraryapp.backend.services;

import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;

public interface BookRentalService {
    LibraryResponse rentBook(String userEmail, Long bookId);
    LibraryResponse returnBook(String userEmail, Long bookId);
}
