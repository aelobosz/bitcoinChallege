package com.alobosz.bitcoinbeetrack.data.source.local;

import com.alobosz.bitcoinbeetrack.data.source.local.model.AddressEntity;

import javax.inject.Inject;

import io.reactivex.Single;

public class LocalDataSource implements ILocalDataSource {
    private BitcoinWalletDatabase database;

    @Inject
    public LocalDataSource(BitcoinWalletDatabase database) {
        this.database = database;
    }

    @Override
    public Single<Long> saveAddress(AddressEntity addressEntity) {
        return database.addressDao().insert(addressEntity);
    }
}
