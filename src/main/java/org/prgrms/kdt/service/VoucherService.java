package org.prgrms.kdt.service;

import org.prgrms.kdt.domain.Voucher;
import org.prgrms.kdt.repository.VoucherRepository;

import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;

public class VoucherService {
    private final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository
                .findById(voucherId)
                .orElseThrow(() -> new RuntimeException(MessageFormat.format("Can not find a voucher for {0}", voucherId)));
    }

    public void useVoucher(Voucher voucher) {

    }

    public void create(int type) {
        voucherRepository.create(type);
    }

    public List<Voucher> list() {
        return voucherRepository.list();
    }
}