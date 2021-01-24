package com.alobosz.bitcoinbeetrack.data.source.local;

import javax.inject.Inject;

public class LocalDataSource implements ILocalDataSource {
    private BitcoinWalletDatabase bitcoinWalletDatabase;

    @Inject
    public LocalDataSource(BitcoinWalletDatabase bitcoinWalletDatabase) {
        this.bitcoinWalletDatabase = bitcoinWalletDatabase;
    }
}
