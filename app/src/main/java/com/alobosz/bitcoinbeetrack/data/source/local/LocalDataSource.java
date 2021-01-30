package com.alobosz.bitcoinbeetrack.data.source.local;

import com.alobosz.bitcoinbeetrack.data.source.local.model.AddressEntity;

import java.util.List;

import io.reactivex.Single;

public interface LocalDataSource {
    Single<Long> saveAddress(AddressEntity addressEntity);

    Single<AddressEntity> getAddress(String address);

    Single<Integer> deleteAddress();
}
