package com.montrack.montrack.pocket.repository;

import com.montrack.montrack.pocket.model.Pocket;
import com.montrack.montrack.wallet.model.dto.Summary;
import com.montrack.montrack.wallet.model.dto.SummaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PocketRepository extends JpaRepository<Pocket, Long> {
    Optional<List<Pocket>> findAllByWalletId(Long id);

    @Query(value = "SELECT " +
            "(SELECT SUM(t.amount) FROM Trx t JOIN Pocket p ON t.pocket.id = p.id WHERE p.wallet.id = :walletId) AS total, " +
            "(SELECT SUM(t.amount) FROM Trx t JOIN Pocket p ON t.pocket.id = p.id WHERE p.wallet.id = :walletId AND t.amount > 0) AS income, " +
            "(SELECT SUM(t.amount) FROM Trx t JOIN Pocket p ON t.pocket.id = p.id WHERE p.wallet.id = :walletId AND t.amount < 0) AS expense, " +
            "(SELECT COUNT(p.id) FROM Pocket p WHERE p.wallet.id = :walletId) AS numOfPockets")
    Summary summarizeWallet(@Param("walletId") Long walletId);

}
