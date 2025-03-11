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
public class AccountInfo {

    private String name;

    @Schema(name = "email")
    private String email;
    
    @Schema(name = "uid")
    private Long uid;
    
    @Schema(name = "is_active")
    private Integer is_active;
}
