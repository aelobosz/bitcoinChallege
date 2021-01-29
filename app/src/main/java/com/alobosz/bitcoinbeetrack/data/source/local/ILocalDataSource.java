package com.alobosz.bitcoinbeetrack.data.source.local;

import com.alobosz.bitcoinbeetrack.data.source.local.model.AddressEntity;

import io.reactivex.Single;

public interface ILocalDataSource {
    Single<Long> saveAddress(AddressEntity addressEntity);
}
