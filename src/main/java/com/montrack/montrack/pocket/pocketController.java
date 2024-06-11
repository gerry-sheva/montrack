package com.montrack.montrack.pocket;

import com.montrack.montrack.pocket.model.Pocket;
import com.montrack.montrack.pocket.model.dto.PocketDto;
import com.montrack.montrack.pocket.service.PocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pocket")
public class pocketController {
    private final PocketService pocketService;

    @PostMapping
    public void createPocket(@RequestBody Pocket pocket) {
        pocketService.createPocket(pocket);
    }

    @GetMapping("/{walletId}")
    public List<PocketDto> getPocket(@PathVariable Long walletId) {
        return pocketService.getPockets(walletId);
    }
}
