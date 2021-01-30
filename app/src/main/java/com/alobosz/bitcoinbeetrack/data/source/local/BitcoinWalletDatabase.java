package com.alobosz.bitcoinbeetrack.data.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.alobosz.bitcoinbeetrack.data.source.local.dao.AddressDao;
import com.alobosz.bitcoinbeetrack.data.source.local.model.AddressEntity;
import com.alobosz.bitcoinbeetrack.util.DataBaseConstants;

@Database(
        entities = {AddressEntity.class},
        version = DataBaseConstants.DATABASE_VERSION,
        exportSchema = false
)
public abstract class BitcoinWalletDatabase extends RoomDatabase {

    public abstract AddressDao addressDao();
}
