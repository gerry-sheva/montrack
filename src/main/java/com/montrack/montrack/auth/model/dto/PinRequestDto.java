package com.montrack.montrack.auth.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PinRequestDto {
    @NotBlank
    @Size(min = 4, max = 4)
    private String newPin;

    @NotBlank
    @Size(min = 4, max = 4)
    private String confirmPin;

    @NotBlank
    private String oldPin;
}
