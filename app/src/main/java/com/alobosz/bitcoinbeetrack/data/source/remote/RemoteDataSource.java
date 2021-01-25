package com.alobosz.bitcoinbeetrack.data.source.remote;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.Single;

public class RemoteDataSource implements IRemoteDataSource {
    private ApiBlockCypher apiBlockCypher;

    @Inject
    public RemoteDataSource(ApiBlockCypher apiBlockCypher) {
        this.apiBlockCypher = apiBlockCypher;
    }

    @Override
    public Single<Address> generateAddress() {
        return apiBlockCypher.generateAddress();
    }
}
