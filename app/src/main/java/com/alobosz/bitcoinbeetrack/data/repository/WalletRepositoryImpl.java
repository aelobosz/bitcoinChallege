package com.alobosz.bitcoinbeetrack.data.repository;

import com.alobosz.bitcoinbeetrack.data.mapper.DataMapper;
import com.alobosz.bitcoinbeetrack.data.source.local.LocalDataSource;
import com.alobosz.bitcoinbeetrack.data.source.remote.RemoteDataSource;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;
import com.alobosz.bitcoinbeetrack.domain.repository.WalletRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class WalletRepositoryImpl implements WalletRepository {
    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;

    @Inject
    public WalletRepositoryImpl(
            LocalDataSource localDataSource,
            RemoteDataSource remoteDataSource) {
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

    @Override
    public Single<Address> getAddress(String address) {
        return localDataSource.getAddress(address).map(DataMapper::entityToAddress);
    }

    @Override
    public Single<Integer> deleteAddress() {
        return localDataSource.deleteAddress();
    }
}

