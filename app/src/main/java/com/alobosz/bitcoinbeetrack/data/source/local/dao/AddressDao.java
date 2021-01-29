package com.alobosz.bitcoinbeetrack.data.source.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.alobosz.bitcoinbeetrack.data.source.local.model.AddressEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface AddressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insert(AddressEntity addressEntity);

    @Query("SELECT * FROM addressTable")
    List<AddressEntity> loadAllAddresses();

    @Query("SELECT * FROM addressTable where walletAddress = :addressString")
    AddressEntity getAddressByAddress(String addressString);

}
