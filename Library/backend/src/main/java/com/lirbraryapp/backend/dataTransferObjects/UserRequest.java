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
public class UserRequest {

    @Schema(name = "User Account First Name")
    private String firstName;

    @Schema(name = "User Account Last Name")
    private String lastName;

    @Schema(name = "User Account Gender")
    private String gender;

    @Schema(name = "User Account State")
    private String state;
    
    @Schema(name = "User Account Status")
    private String status;

    @Schema(name = "User Account Email")
    private String email;

    @Schema(name = "User Account UID")
    private String UID;

}