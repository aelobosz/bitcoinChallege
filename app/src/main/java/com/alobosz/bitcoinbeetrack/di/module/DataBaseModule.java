package com.alobosz.bitcoinbeetrack.di.module;

import android.content.Context;

import androidx.room.Room;

import com.alobosz.bitcoinbeetrack.data.source.local.BitcoinWalletDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {
    @Provides
    @Singleton
    BitcoinWalletDatabase providesRoom(Context appContext) {
        return Room.databaseBuilder(
                appContext,
                BitcoinWalletDatabase.class,
                "database-bitcoin-wallet")
                .fallbackToDestructiveMigration().build();
    }

   /* @Singleton
    @Provides
    BitcoinDao provideUserDao(BitcoinWalletDatabase bitcoinWalletDatabase)
    {
        return bitcoinWalletDatabase.userDao;
    }*/
}
