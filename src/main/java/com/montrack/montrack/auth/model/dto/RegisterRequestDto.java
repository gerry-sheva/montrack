package com.montrack.montrack.auth.model.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String email;
    private String password;
}