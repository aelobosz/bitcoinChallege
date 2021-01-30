package com.alobosz.bitcoinbeetrack.data.source.local;

import com.alobosz.bitcoinbeetrack.data.source.local.model.AddressEntity;

import javax.inject.Inject;

import io.reactivex.Single;

public class LocalDataSourceImpl implements LocalDataSource {
    private final BitcoinWalletDatabase database;

    @Inject
    public LocalDataSourceImpl(BitcoinWalletDatabase database) {
        this.database = database;
    }

    @Override
    public Single<Long> saveAddress(AddressEntity addressEntity) {
        return database.addressDao().insert(addressEntity);
    }

    @Override
    public Single<AddressEntity> getAddress(String address) {
        return database.addressDao().getWalletByAddress(address);
    }

    @Override
    public Single<Integer> deleteAddress() {
        return database.addressDao().deleteAllTransaction();
    }
}
