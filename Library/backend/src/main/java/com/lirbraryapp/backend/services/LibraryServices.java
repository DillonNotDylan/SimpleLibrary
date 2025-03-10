package com.lirbraryapp.backend.services;

import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
import com.lirbraryapp.backend.dataTransferObjects.LibraryRequest;

public interface LibraryServices {
    LibraryResponse getAllBooks();
    LibraryResponse searchForBook(LibraryRequest libraryRequest);
}
