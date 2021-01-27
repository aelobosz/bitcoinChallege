package com.alobosz.bitcoinbeetrack.data.source.remote;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Balance;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Transaction;

import io.reactivex.Single;
import io.reactivex.Single;

public interface IRemoteDataSource {

    Single<Address> generateAddress();

    Single<Transaction> getTransactions(String address);

    Single<Balance> getBalance(String address);
}
