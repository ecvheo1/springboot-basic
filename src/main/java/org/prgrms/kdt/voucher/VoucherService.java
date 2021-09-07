package org.prgrms.kdt.voucher;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.prgrms.kdt.exception.ResourceNotFoundException;
import org.prgrms.kdt.mapper.VoucherMapper;
import org.springframework.stereotype.Service;

/**
 * Created by yhh1056
 * Date: 2021/09/04 Time: 10:27 오전
 */
@Service
public class VoucherService {

    private final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public VoucherDto getVoucherById(String voucherId) {
        return voucherRepository.findById(UUID.fromString(voucherId))
                .map(VoucherMapper::voucherToVoucherDto)
                .orElseThrow(() -> new ResourceNotFoundException("not found voucherId : " + voucherId));
    }

    public List<VoucherDto> getVouchers(String customerId) {
        return voucherRepository.findVouchersByCustomerId(UUID.fromString(customerId)).stream()
                .map(VoucherMapper::voucherToVoucherDto)
                .collect(Collectors.toList());
    }
}