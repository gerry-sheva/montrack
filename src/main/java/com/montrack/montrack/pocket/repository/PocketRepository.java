package com.montrack.montrack.pocket.repository;

import com.montrack.montrack.pocket.model.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PocketRepository extends JpaRepository<Pocket, Long> {
    Optional<List<Pocket>> findAllByWalletId(Long id);
}
