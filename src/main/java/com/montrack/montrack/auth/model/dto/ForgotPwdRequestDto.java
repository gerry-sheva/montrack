package com.montrack.montrack.auth.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ForgotPwdRequestDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String newPassword;
}
