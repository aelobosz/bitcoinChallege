package com.alobosz.bitcoinbeetrack.di.module;

import com.alobosz.bitcoinbeetrack.data.repository.WalletRepository;
import com.alobosz.bitcoinbeetrack.data.source.local.ILocalDataSource;
import com.alobosz.bitcoinbeetrack.data.source.local.LocalDataSource;
import com.alobosz.bitcoinbeetrack.data.source.remote.IRemoteDataSource;
import com.alobosz.bitcoinbeetrack.data.source.remote.RemoteDataSource;
import com.alobosz.bitcoinbeetrack.domain.repository.IWalletRepository;

import dagger.Binds;
import dagger.Module;

@Module
abstract public class RepositoryModule {

    @Binds
    abstract ILocalDataSource bindLocalDataSource(LocalDataSource localDataSource);

    @Binds
    abstract IRemoteDataSource bindRemoteDataSource(RemoteDataSource remoteDataSource);

    @Binds
    abstract IWalletRepository bindRepository(WalletRepository walletRepository);
}
