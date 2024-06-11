package com.montrack.montrack.trx;

import com.montrack.montrack.trx.model.Trx;
import com.montrack.montrack.trx.service.TrxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/trx")
public class trxController {
    private final TrxService trxService;

    @PostMapping
    public String createTrx(@RequestBody Trx trx) {
        trxService.createTrx(trx);
        return "success";
    }
}
