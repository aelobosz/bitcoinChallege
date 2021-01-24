package com.alobosz.bitcoinbeetrack.data.source.remote;

import javax.inject.Inject;

public class RemoteDataSource implements IRemoteDataSource {
    private ApiBitcoinWallet apiBitcoinWallet;

    @Inject
    public RemoteDataSource(ApiBitcoinWallet apiBitcoinWallet) {
        this.apiBitcoinWallet = apiBitcoinWallet;
    }
}
