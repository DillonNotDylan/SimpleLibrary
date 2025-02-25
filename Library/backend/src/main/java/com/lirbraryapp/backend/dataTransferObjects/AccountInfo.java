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

    @Schema(name = "User User Name")
    private String name;

    @Schema(name = "User Email")
    private String email;
    
    @Schema(name = "User UID")
    private String uid;
    
    @Schema(name = "User UID")
    private Integer activeStatus;
}
