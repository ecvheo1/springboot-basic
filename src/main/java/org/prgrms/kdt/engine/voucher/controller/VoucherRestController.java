package org.prgrms.kdt.engine.voucher.controller;

import org.prgrms.kdt.engine.voucher.domain.Voucher;
import org.prgrms.kdt.engine.voucher.dto.VoucherDto;
import org.prgrms.kdt.engine.voucher.service.VoucherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
public class VoucherRestController {
    private final VoucherService voucherService;

    public VoucherRestController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping("/api/v1/vouchers")
    public Map<UUID, Voucher> listVouchers() {
        var allVouchers = voucherService.listVoucher();
        if (allVouchers.isEmpty())
            return Map.of();
        return allVouchers.get();
    }

    @PostMapping("/api/v1/vouchers")
    public Voucher createVoucher(@RequestBody VoucherDto voucherDto) {
        return voucherService.createVoucher(voucherDto.getType(), voucherDto.getRate());
    }

    @GetMapping("/api/v1/vouchers/{voucherId}")
    public Voucher findVoucher(@PathVariable("voucherId") UUID voucherId) {
        Optional<Voucher> voucher = voucherService.getVoucher(voucherId);

        if (voucher.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "voucher does not exist");

        return voucher.get();
    }

    @DeleteMapping("/api/v1/vouchers/{voucherId}")
    public String deleteVoucher(@PathVariable("voucherId") UUID voucherId) {
        Optional<Voucher> voucher = voucherService.getVoucher(voucherId);

        if (voucher.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "voucher does not exist");

        voucherService.deleteVoucher(voucherId);
        return "deleted voucher " + voucherId;
    }
}