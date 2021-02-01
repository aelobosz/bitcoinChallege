package com.alobosz.bitcoinbeetrack.data.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BalanceDTO {
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("total_received")
    @Expose
    private Float totalReceived;
    @SerializedName("total_sent")
    @Expose
    private Float totalSent;
    @SerializedName("balance")
    @Expose
    private Float balance;
    @SerializedName("unconfirmed_balance")
    @Expose
    private Float unconfirmedBalance;
    @SerializedName("final_balance")
    @Expose
    private Float finalBalance;
    @SerializedName("n_tx")
    @Expose
    private Float nTx;
    @SerializedName("unconfirmed_n_tx")
    @Expose
    private Float unconfirmedNTx;
    @SerializedName("final_n_tx")
    @Expose
    private Float finalNTx;


    public String getAddress() {
        return address;
    }

    public Float getBalance() {
        return balance;
    }

    public Float getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public Float getFinalBalance() {
        return finalBalance;
    }
}
