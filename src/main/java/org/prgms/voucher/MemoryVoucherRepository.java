package org.prgms.voucher;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Primary
public class MemoryVoucherRepository implements VoucherRepository {

    private final Map<UUID, Voucher> storage;

    public MemoryVoucherRepository() {
        this.storage = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<Voucher> findById(UUID voucherId) {
        return Optional.ofNullable(storage.get(voucherId)); // null일 경우 empty
    }

    @Override
    public Voucher save(Voucher voucher) {
        storage.put(voucher.getVoucherId(), voucher);
        return voucher;
    }

    @Override
    public List<Voucher> findAll() {
        return new ArrayList<>(storage.values());
    }


}