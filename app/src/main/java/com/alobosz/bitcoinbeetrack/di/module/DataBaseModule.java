package com.alobosz.bitcoinbeetrack.di.module;

import android.content.Context;

import androidx.room.Room;

import com.alobosz.bitcoinbeetrack.data.source.local.BitcoinWalletDatabase;
import com.alobosz.bitcoinbeetrack.util.DataBaseConstants;

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
                DataBaseConstants.DATABASE_NAME)
                .fallbackToDestructiveMigration().build();
    }
}
