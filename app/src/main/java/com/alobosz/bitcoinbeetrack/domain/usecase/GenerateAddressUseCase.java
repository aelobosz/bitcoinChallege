package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.repository.WalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class GenerateAddressUseCase extends BaseSingleUseCase<Address> {
    private final WalletRepository repository;

    @Inject
    public GenerateAddressUseCase(WalletRepository walletRepository) {
        this.repository = walletRepository;
    }


    @NotNull
    @Override
    public Single<Address> buildSingleUseCase() {
        return repository.generateAddress();
    }
}
