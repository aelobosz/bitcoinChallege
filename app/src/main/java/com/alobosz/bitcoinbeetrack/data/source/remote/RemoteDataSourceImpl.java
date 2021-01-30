package com.alobosz.bitcoinbeetrack.data.source.remote;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alobosz.bitcoinbeetrack.data.mapper.DataMapper;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteDataSourceImpl implements RemoteDataSource {
    private final BlockCypherAddressApi apiBlockCypher;

    @Inject
    public RemoteDataSourceImpl(BlockCypherAddressApi blockCypherAddressApi) {
        this.apiBlockCypher = blockCypherAddressApi;
    }

    @Override
    public Single<Address> generateAddress() {

        return apiBlockCypher.generateAddress().map(DataMapper::toAddress);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Single<Transactions> getTransactions(String address) {
        return apiBlockCypher.getAddressTransactions(address).map(DataMapper::toTransactions);
    }

    @Override
    public Single<Balance> getBalance(String address) {
        return apiBlockCypher.getAddressBalance(address).map(DataMapper::toBalance);
    }
}
