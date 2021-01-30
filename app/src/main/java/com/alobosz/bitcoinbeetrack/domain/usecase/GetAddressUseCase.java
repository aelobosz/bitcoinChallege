package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.repository.WalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetAddressUseCase extends BaseSingleUseCase<Address> {
    WalletRepository repository;

    @Inject
    GetAddressUseCase(WalletRepository repository) {
        this.repository = repository;

    }

    private String  address;

    public void getAddress(String address) {
        this.address = address;
    }

    @NotNull
    @Override
    public Single<Address> buildSingleUseCase() {
        return repository.getAddress(address);
    }
}
