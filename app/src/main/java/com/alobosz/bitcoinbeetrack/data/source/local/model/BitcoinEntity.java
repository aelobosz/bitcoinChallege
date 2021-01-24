package com.alobosz.bitcoinbeetrack.data.source.local.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BitcoinEntity {
    @PrimaryKey
    public int uid;
}
