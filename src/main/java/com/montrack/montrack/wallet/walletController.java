package com.montrack.montrack.wallet;

import com.montrack.montrack.wallet.model.Wallet;
import com.montrack.montrack.wallet.model.dto.SummaryDto;
import com.montrack.montrack.wallet.model.dto.WalletDto;
import com.montrack.montrack.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/wallet")
public class walletController {

    private final WalletService walletService;

    @PostMapping
    public String createWallet(@RequestBody Wallet wallet) {
        walletService.createWallet(wallet);
        return "Wallet created";
    }

    @GetMapping
    public List<WalletDto> getAllWallets() {
        return walletService.retrieveWallets();
    }

    @PutMapping("/active/{id}")
    public WalletDto activateWallet(@PathVariable("id") Long id) {
        return walletService.changeActiveWallet(id);
    }

    @PutMapping("/{id}")
    public WalletDto updateWallet(@PathVariable("id") Long id, @RequestBody WalletDto walletDto) {
        return walletService.updateWallet(id, walletDto);
    }

    @GetMapping("/summary/{id}")
    public SummaryDto retrieveSummary(@PathVariable("id") Long id) {
        return walletService.summarizeWallet(id);
    }
}
