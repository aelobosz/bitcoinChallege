package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class SaveAddressUseCase extends BaseSingleUseCase<Long> {
    IWalletRepository repository;

    @Inject
    SaveAddressUseCase(IWalletRepository repository) {
        this.repository = repository;

    }

    private Address address = null;

    public void saveAddress(Address address) {
        this.address = address;
    }

    @NotNull
    @Override
    public Single<Long> buildSingleUseCase() {
        return repository.saveAddress(address);
    }
}
