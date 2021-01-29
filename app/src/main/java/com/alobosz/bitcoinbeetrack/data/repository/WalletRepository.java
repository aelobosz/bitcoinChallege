package com.alobosz.bitcoinbeetrack.data.repository;

import com.alobosz.bitcoinbeetrack.data.mapper.DataMapper;
import com.alobosz.bitcoinbeetrack.data.source.local.ILocalDataSource;
import com.alobosz.bitcoinbeetrack.data.source.remote.IRemoteDataSource;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;

import javax.inject.Inject;

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

    @Override
    public Single<Balance> getBalance() {
        return null;
    }

    @Override
    public Single<Transactions> getTransactions() {
        return null;
    }

    @Override
    public Single<Long> saveAddress(Address address) {
        return localDataSource.saveAddress(DataMapper.toEntity(address));
    }
}

