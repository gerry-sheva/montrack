package com.montrack.montrack.wallet;

import com.montrack.montrack.wallet.model.Wallet;
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
    public String activateWallet(@PathVariable("id") Long id) {
        walletService.changeActiveWallet(id);
        return "changed";
    }
}
