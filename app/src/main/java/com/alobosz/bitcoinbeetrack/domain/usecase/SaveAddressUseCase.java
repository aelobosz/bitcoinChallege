package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.repository.WalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class SaveAddressUseCase extends BaseSingleUseCase<Long> {
    WalletRepository repository;

    @Inject
    SaveAddressUseCase(WalletRepository repository) {
        this.repository = repository;

    }

    private Address address = null;

    public void saveAddress(Address address) {
        this.address = address;
    }


    @Override
    public @NotNull Single<Long> buildSingleUseCase() {
        return repository.saveAddress(address);
    }
}
