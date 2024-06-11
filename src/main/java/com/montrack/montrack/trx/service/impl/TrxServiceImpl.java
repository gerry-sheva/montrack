package com.montrack.montrack.trx.service.impl;

import com.montrack.montrack.trx.model.Trx;
import com.montrack.montrack.trx.repository.TrxRepository;
import com.montrack.montrack.trx.service.TrxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrxServiceImpl implements TrxService {
    private final TrxRepository trxRepository;

    public void createTrx(Trx trx) {
        trxRepository.save(trx);
    }
}
