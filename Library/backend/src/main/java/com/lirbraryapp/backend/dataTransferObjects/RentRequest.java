package com.lirbraryapp.backend.dataTransferObjects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RentRequest {
    @Schema(name = "Book availability Status")
    private String bookStatus;
}
