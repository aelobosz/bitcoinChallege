package com.alobosz.bitcoinbeetrack.domain.model;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class Balance {
    String address;
    String balance;
    String unconfirmedBalance;
    String finalBalance;

    public Balance(String address, String balance, String unconfirmedBalance, String finalBalance) {
        this.address = address;
        this.balance = balance;
        this.unconfirmedBalance = unconfirmedBalance;
        this.finalBalance = finalBalance;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public void setUnconfirmedBalance(String unconfirmedBalance) {
        this.unconfirmedBalance = unconfirmedBalance;
    }

    public String getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(String finalBalance) {
        this.finalBalance = finalBalance;
    }

}
