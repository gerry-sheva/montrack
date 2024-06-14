package com.montrack.montrack.wallet.service;

import com.montrack.montrack.wallet.model.Wallet;
import com.montrack.montrack.wallet.model.dto.Summary;
import com.montrack.montrack.wallet.model.dto.SummaryDto;
import com.montrack.montrack.wallet.model.dto.WalletDto;

import java.util.List;

public interface WalletService {
    void createWallet(Wallet wallet);
    List<WalletDto> retrieveWallets();
    WalletDto changeActiveWallet(Long walletId);
    WalletDto updateWallet(Long walletId, WalletDto walletDto);
    Summary summarizeWallet(Long walletId);
}
