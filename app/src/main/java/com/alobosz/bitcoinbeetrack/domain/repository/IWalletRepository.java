package com.alobosz.bitcoinbeetrack.domain.repository;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Balance;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Transaction;

import io.reactivex.Single;
import io.reactivex.Single;

public interface IWalletRepository {
    Single<Address> generateAddress();

    Single<Balance> getBalance();

    Single<Transaction> getTransactions();
}

