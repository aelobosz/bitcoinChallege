package com.alobosz.bitcoinbeetrack.data.source.remote;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;

import io.reactivex.Single;

public interface RemoteDataSource {

    Single<Address> generateAddress();

    Single<Transactions> getTransactions(String address);

    Single<Balance> getBalance(String address);
}
