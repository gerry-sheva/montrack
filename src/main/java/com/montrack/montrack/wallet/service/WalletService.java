package com.montrack.montrack.wallet.service;

import com.montrack.montrack.wallet.model.Wallet;
import com.montrack.montrack.wallet.model.dto.WalletDto;

import java.util.List;

public interface WalletService {
    void createWallet(Wallet wallet);
    List<WalletDto> retrieveWallets();
}
