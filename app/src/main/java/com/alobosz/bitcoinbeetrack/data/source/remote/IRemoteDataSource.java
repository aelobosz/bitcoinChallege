package com.alobosz.bitcoinbeetrack.data.source.remote;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.BalanceDTO;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.TransactionDTO;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;

import io.reactivex.Single;

public interface IRemoteDataSource {

    Single<Address> generateAddress();

    Single<Transactions> getTransactions(String address);

    Single<Balance> getBalance(String address);
}
