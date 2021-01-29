package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.BalanceDTO;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetBalanceUseCase extends BaseSingleUseCase<Balance> {
    private final IWalletRepository repository;

    @Inject
    GetBalanceUseCase(IWalletRepository repository) {
        this.repository = repository;

    }

    @NotNull
    @Override
    public Single<Balance> buildSingleUseCase() {
        return repository.getBalance();
    }
}
