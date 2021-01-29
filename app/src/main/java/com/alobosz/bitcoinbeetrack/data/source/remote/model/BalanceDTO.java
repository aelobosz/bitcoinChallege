package com.alobosz.bitcoinbeetrack.data.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BalanceDTO {
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("total_received")
    @Expose
    private Integer totalReceived;
    @SerializedName("total_sent")
    @Expose
    private Integer totalSent;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("unconfirmed_balance")
    @Expose
    private Integer unconfirmedBalance;
    @SerializedName("final_balance")
    @Expose
    private Integer finalBalance;
    @SerializedName("n_tx")
    @Expose
    private Integer nTx;
    @SerializedName("unconfirmed_n_tx")
    @Expose
    private Integer unconfirmedNTx;
    @SerializedName("final_n_tx")
    @Expose
    private Integer finalNTx;


    public String getAddress() {
        return address;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public Integer getFinalBalance() {
        return finalBalance;
    }
}
