package com.alobosz.bitcoinbeetrack.di.module;

import com.alobosz.bitcoinbeetrack.data.repository.WalletRepositoryImpl;
import com.alobosz.bitcoinbeetrack.data.source.local.LocalDataSource;
import com.alobosz.bitcoinbeetrack.data.source.local.LocalDataSourceImpl;
import com.alobosz.bitcoinbeetrack.data.source.remote.RemoteDataSource;
import com.alobosz.bitcoinbeetrack.data.source.remote.RemoteDataSourceImpl;
import com.alobosz.bitcoinbeetrack.domain.repository.WalletRepository;

import dagger.Binds;
import dagger.Module;

@Module
abstract public class RepositoryModule {

    @Binds
    abstract LocalDataSource bindLocalDataSource(LocalDataSourceImpl localDataSourceImpl);

    @Binds
    abstract RemoteDataSource bindRemoteDataSource(RemoteDataSourceImpl remoteDataSourceImpl);

    @Binds
    abstract WalletRepository bindRepository(WalletRepositoryImpl walletRepositoryImpl);
}
