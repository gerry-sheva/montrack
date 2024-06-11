package com.montrack.montrack.wallet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {
    private Long id;
    private String name;
    private String currency;
    private Long balance;
    private boolean isActive;
}
