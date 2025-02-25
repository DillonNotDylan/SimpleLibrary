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

public class StatusRequest {
    @Schema(name = "User Account Email")
    private String email;

    @Schema(name = "User Account Status")
    private String status;
}
