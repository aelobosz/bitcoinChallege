package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.domain.repository.WalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class DeleteAddressUseCase extends BaseSingleUseCase<Integer> {
    WalletRepository repository;

    @Inject
    DeleteAddressUseCase(WalletRepository repository) {
        this.repository = repository;
    }

    @NotNull
    @Override
    public Single<Integer> buildSingleUseCase() {
        return repository.deleteAddress();
    }
}
