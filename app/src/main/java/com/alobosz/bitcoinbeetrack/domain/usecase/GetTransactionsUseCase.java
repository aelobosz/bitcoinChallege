package com.alobosz.bitcoinbeetrack.domain.usecase;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Transaction;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;
import com.alobosz.bitcoinbeetrack.domain.usecase.base.BaseSingleUseCase;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetTransactionsUseCase extends BaseSingleUseCase<Transaction> {
    private final IWalletRepository repository;

    @Inject
    public GetTransactionsUseCase(IWalletRepository repository) {
        this.repository = repository;
    }

    @NotNull
    @Override
    public Single<Transaction> buildSingleUseCase() {
        return repository.getTransactions();
    }
}
