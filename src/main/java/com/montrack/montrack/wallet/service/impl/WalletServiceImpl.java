package com.montrack.montrack.wallet.service.impl;

import com.montrack.montrack.pocket.repository.PocketRepository;
import com.montrack.montrack.wallet.model.Wallet;
import com.montrack.montrack.wallet.model.dto.Summary;
import com.montrack.montrack.wallet.model.dto.SummaryDto;
import com.montrack.montrack.wallet.model.dto.WalletDto;
import com.montrack.montrack.wallet.repository.WalletRepository;
import com.montrack.montrack.wallet.service.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final PocketRepository pocketRepository;

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
            WalletDto walletDto = new WalletDto(wallet.getId(), wallet.getName(), wallet.getCurrency(), wallet.getBalance(), wallet.getIsActive());
            wallets.add(walletDto);
        });

        return wallets;
    }

    @Override
    @Transactional
    public WalletDto changeActiveWallet(Long walletId) {
        Optional<Wallet> walletOption = walletRepository.findByUserIdAndIsActive(2L, true);
        System.out.println(walletOption);
        if (walletOption.isPresent()) {
            Wallet activeWallet = walletOption.get();
            System.out.println(activeWallet);
            activeWallet.setIsActive(false);
            walletRepository.save(activeWallet);
        }
        Optional<Wallet> walletOption2 = walletRepository.findById(walletId);
        if (walletOption2.isEmpty()) {
            return null;
        }
        Wallet selectedWallet = walletOption2.get();
        selectedWallet.setIsActive(true);
        walletRepository.save(selectedWallet);
        return new WalletDto(selectedWallet.getId(), selectedWallet.getName(), selectedWallet.getCurrency(), selectedWallet.getBalance(), selectedWallet.getIsActive());
    }

    @Override
    public WalletDto updateWallet(Long walletId, WalletDto walletDto) {
        Optional<Wallet> walletOption = walletRepository.findById(walletId);
        if (walletOption.isEmpty()){
            return null;
        }
        Wallet wallet = walletOption.get();
        wallet.setName(walletDto.getName());
        wallet.setCurrency(walletDto.getCurrency());
        wallet.setBalance(walletDto.getBalance());
        walletRepository.save(wallet);
        return walletDto;
    }

    @Override
    public SummaryDto summarizeWallet(Long walletId) {
        Summary result = pocketRepository.summarizeWallet(walletId);
        int total = result.getTotal();
        int income = result.getIncome();
        int expense = result.getExpense();
        int numOfPockets = result.getNumOfPockets();
        return new SummaryDto(total, income, expense, numOfPockets);
    }
}
