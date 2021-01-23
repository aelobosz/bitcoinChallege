package com.alobosz.bitcoinbeetrack.data.repository;

import com.alobosz.bitcoinbeetrack.data.source.remote.ApiBitcoin;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;

import javax.inject.Inject;

public class WalletRepository implements IWalletRepository {
    private final ApiBitcoin apiBitcoin;
    @Inject
    public WalletRepository(ApiBitcoin apiBitcoin) {
        this.apiBitcoin = apiBitcoin;
    }
}

