package com.alobosz.bitcoinbeetrack.data.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.alobosz.bitcoinbeetrack.data.model.BitcoinEntity;
import com.alobosz.bitcoinbeetrack.data.source.local.dao.BitcoinDao;
import com.alobosz.bitcoinbeetrack.util.DataBaseConstants;

@Database(
        entities = {BitcoinEntity.class},
        version = DataBaseConstants.DATABASE_VERSION,
        exportSchema = false
)
public abstract class BitcoinWalletDatabase extends RoomDatabase {

    public abstract BitcoinDao bitcoinDao();
}
