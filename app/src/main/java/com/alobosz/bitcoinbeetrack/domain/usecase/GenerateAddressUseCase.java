package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.AddressDTO;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class GenerateAddressUseCase extends BaseSingleUseCase<Address> {
    private final IWalletRepository repository;

    @Inject
    public GenerateAddressUseCase(IWalletRepository iWalletRepository) {
        this.repository = iWalletRepository;
    }


    @NotNull
    @Override
    public Single<Address> buildSingleUseCase() {
        return repository.generateAddress();
    }
}
