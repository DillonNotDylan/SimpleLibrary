package com.lirbraryapp.backend.dataTransferObjects;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryResponse {

    @Schema(name = "HTTP Response Code")
    private String responseCode;
    
    @Schema(name = "API Response Message")
    private String responseMessage;
    
    @Schema(name = "Book List")
    private List bookList;

    @Schema(name = "Misc. account information")
    private AccountInfo accountInfo;

}