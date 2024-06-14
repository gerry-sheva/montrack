package com.montrack.montrack.auth.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PinRequestDto {
    @NotBlank
    private String newPin;
    @NotBlank
    private String oldPin;
}
