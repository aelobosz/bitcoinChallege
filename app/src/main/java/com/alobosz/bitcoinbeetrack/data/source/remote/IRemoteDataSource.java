package com.alobosz.bitcoinbeetrack.data.source.remote;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;

import io.reactivex.Single;
import io.reactivex.Single;

public interface IRemoteDataSource {

    Single<Address> generateAddress();
}
