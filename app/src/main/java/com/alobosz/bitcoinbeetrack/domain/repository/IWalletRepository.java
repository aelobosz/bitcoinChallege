package com.alobosz.bitcoinbeetrack.domain.repository;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;

import io.reactivex.Single;

public interface IWalletRepository {
    Single<Address> generateAddress();

    Single<Balance> getBalance();

    Single<Transactions> getTransactions();

    Single<Long> saveAddress(Address address);
}

