package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.repository.WalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetBalanceUseCase extends BaseSingleUseCase<Balance> {
    private final WalletRepository repository;

    @Inject
    GetBalanceUseCase(WalletRepository repository) {
        this.repository = repository;

    }

    private String  address;

    public void setAddress(String address) {
        this.address = address;
    }

    @NotNull
    @Override
    public Single<Balance> buildSingleUseCase() { return repository.getBalance(address); }
}
