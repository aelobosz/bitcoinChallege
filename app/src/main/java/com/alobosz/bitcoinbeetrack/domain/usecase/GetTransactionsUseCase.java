package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.domain.model.Transactions;
import com.alobosz.bitcoinbeetrack.domain.repository.WalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetTransactionsUseCase extends BaseSingleUseCase<Transactions> {
    private final WalletRepository repository;

    @Inject
    public GetTransactionsUseCase(WalletRepository repository) {
        this.repository = repository;
    }

    @NotNull
    @Override
    public Single<Transactions> buildSingleUseCase() {
        return repository.getTransactions();
    }
}
