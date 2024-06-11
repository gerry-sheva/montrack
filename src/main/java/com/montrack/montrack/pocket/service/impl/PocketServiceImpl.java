package com.montrack.montrack.pocket.service.impl;

import com.montrack.montrack.pocket.model.Pocket;
import com.montrack.montrack.pocket.model.dto.PocketDto;
import com.montrack.montrack.pocket.repository.PocketRepository;
import com.montrack.montrack.pocket.service.PocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PocketServiceImpl implements PocketService {

    private final PocketRepository pocketRepository;

    @Override
    public void createPocket(Pocket pocket) {
        pocketRepository.save(pocket);
    }

    @Override
    public List<PocketDto> getPockets(Long walletId) {
        Optional<List<Pocket>> optionalPockets = pocketRepository.findAllByWalletId(walletId);
        if (optionalPockets.isEmpty()) {
            return null;
        }
        List<Pocket> pockets = optionalPockets.get();
        List<PocketDto> pocketDtos = new ArrayList<>();
        for (Pocket pocket : pockets) {
            PocketDto pocketDto = new PocketDto();
            pocketDto.setId(pocket.getId());
            pocketDto.setName(pocket.getName());
            pocketDto.setDescription(pocket.getDescription());
            pocketDto.setEmoji(pocket.getEmoji());
            pocketDto.setBalance(pocket.getBalance());
            pocketDto.setExpense(pocketDto.getExpense());
            pocketDtos.add(pocketDto);
        }
        return pocketDtos;
    }
}
