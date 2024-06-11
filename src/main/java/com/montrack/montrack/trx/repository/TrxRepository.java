package com.montrack.montrack.trx.repository;

import com.montrack.montrack.trx.model.Trx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrxRepository extends JpaRepository<Trx, Long> {
}
