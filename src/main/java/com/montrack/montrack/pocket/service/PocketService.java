package com.montrack.montrack.pocket.service;

import com.montrack.montrack.pocket.model.Pocket;
import com.montrack.montrack.pocket.model.dto.PocketDto;

import java.util.List;

public interface PocketService {
    void createPocket(Pocket pocket);
    List<PocketDto> getPockets(Long walletId);
}
