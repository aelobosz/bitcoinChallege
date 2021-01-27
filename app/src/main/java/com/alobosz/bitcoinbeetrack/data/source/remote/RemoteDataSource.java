package com.alobosz.bitcoinbeetrack.data.source.remote;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Balance;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Transaction;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteDataSource implements IRemoteDataSource {
    private final ApiBlockCypher apiBlockCypher;

    @Inject
    public RemoteDataSource(ApiBlockCypher apiBlockCypher) {
        this.apiBlockCypher = apiBlockCypher;
    }

    @Override
    public Single<Address> generateAddress() {
        return apiBlockCypher.generateAddress();
    }

    @Override
    public Single<Transaction> getTransactions(String address) {
        return apiBlockCypher.getAddressTransactions(address);
    }

    @Override
    public Single<Balance> getBalance(String address) {
        return apiBlockCypher.getAddressBalance(address);
    }
}
