package com.montrack.montrack.wallet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SummaryDto {
    private int total;
    private int income;
    private int expense;
    private int numOfPockets;

    public SummaryDto(int total, int income, int expense, int numOfPockets) {
        this.total = total;
        this.income = income;
        this.expense = expense;
        this.numOfPockets = numOfPockets;
    }
}
