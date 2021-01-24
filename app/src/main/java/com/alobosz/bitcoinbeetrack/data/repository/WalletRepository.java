package com.alobosz.bitcoinbeetrack.data.repository;

import com.alobosz.bitcoinbeetrack.data.source.local.ILocalDataSource;
import com.alobosz.bitcoinbeetrack.data.source.remote.IRemoteDataSource;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;

import javax.inject.Inject;

public class WalletRepository implements IWalletRepository {
    private IRemoteDataSource remoteDataSource;
    private ILocalDataSource localDataSource;

    @Inject
    public WalletRepository(
            ILocalDataSource localDataSource,
            IRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }
}

