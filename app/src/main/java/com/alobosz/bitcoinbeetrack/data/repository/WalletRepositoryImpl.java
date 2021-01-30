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
    public Single<Balance> getBalance(String address) {

        return remoteDataSource.getBalance(address);
    }

    @Override
    public Single<Transactions> getTransactions() {
        return null;
    }

    @Override
    public Single<Long> saveAddress(Address address) {
        return Single
                .concat(localDataSource.deleteAddress(),
                        localDataSource.saveAddress(DataMapper.toEntity(address))
                )
                .filter(obj -> false)
                .first(1)
                .map(Number::longValue);
    }

    @Override
    public Single<Address> getAddress(String address) {
        return localDataSource.getAddresses().map(list -> {
                    if (!list.isEmpty())
                        return DataMapper.entityToAddress(list.get(0));
                    else
                        return null;
                }
        );
    }

    @Override
    public Single<Integer> deleteAddress() {
        return localDataSource.deleteAddress();
    }
}

