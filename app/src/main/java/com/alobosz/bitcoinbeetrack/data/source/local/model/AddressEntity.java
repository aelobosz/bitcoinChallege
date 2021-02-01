package com.alobosz.bitcoinbeetrack.data.source.local.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.alobosz.bitcoinbeetrack.util.DataBaseConstants.TABLE_ADDRESS;

@SuppressWarnings({"unused", "RedundantSuppression"})
@Entity(tableName = TABLE_ADDRESS)
public class AddressEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "wallet_address")
    private String walletAddress;
    private String privateKey;
    private String publicKey;
    private String wif;
    @ColumnInfo(name = "created_at")
    private Long createdAt = System.currentTimeMillis();

    public AddressEntity(@NonNull String walletAddress, String privateKey, String publicKey, String wif) {
        this.walletAddress = walletAddress;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.wif = wif;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public @NotNull String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(@NotNull String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getWif() {
        return wif;
    }

    public void setWif(String wif) {
        this.wif = wif;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return walletAddress.equals(that.walletAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletAddress);
    }
}
