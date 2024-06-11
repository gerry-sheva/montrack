package com.montrack.montrack.wallet.repository;

import com.montrack.montrack.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<List<Wallet>> findByUserId(Long userId);
    Optional<Wallet> findByUserIdAndIsActive(Long userId, Boolean isActive);
}
