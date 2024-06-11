package com.montrack.montrack.wallet.service.impl;

import com.montrack.montrack.wallet.model.Wallet;
import com.montrack.montrack.wallet.model.dto.WalletDto;
import com.montrack.montrack.wallet.repository.WalletRepository;
import com.montrack.montrack.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Override
    public void createWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public List<WalletDto> retrieveWallets() {
        Optional<List<Wallet>> walletsOption =  walletRepository.findByUserId(2L);
        if (walletsOption.isEmpty()) {
            return null;
        }
        List<WalletDto>  wallets = new ArrayList<>();
        walletsOption.get().forEach(wallet -> {
            WalletDto walletDto = new WalletDto(wallet.getId(), wallet.getName(), wallet.getCurrency(), wallet.getBalance());
            wallets.add(walletDto);
        });

        return wallets;
    }
}
