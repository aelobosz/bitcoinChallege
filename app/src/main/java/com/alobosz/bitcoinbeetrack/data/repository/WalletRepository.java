package com.alobosz.bitcoinbeetrack.data.repository;

import com.alobosz.bitcoinbeetrack.data.source.local.ILocalDataSource;
import com.alobosz.bitcoinbeetrack.data.source.remote.IRemoteDataSource;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.Single;

public class WalletRepository implements IWalletRepository {
    private final IRemoteDataSource remoteDataSource;
    private final ILocalDataSource localDataSource;

    @Inject
    public WalletRepository(
            ILocalDataSource localDataSource,
            IRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Single<Address> generateAddress() {
        return remoteDataSource.generateAddress();
    }
}

