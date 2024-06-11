package com.montrack.montrack.pocket.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PocketDto {
    private Long id;
    private String name;
    private String description;
    private String emoji;
    private int balance;
    private int expense;
}
