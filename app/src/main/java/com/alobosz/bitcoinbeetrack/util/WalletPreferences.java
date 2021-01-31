package com.alobosz.bitcoinbeetrack.util;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class WalletPreferences {
    private SharedPreferences sharedPreferences;

    @Inject
    public WalletPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveData(String key, boolean hasAddress) {
        sharedPreferences.edit().putBoolean(key, hasAddress).apply();
    }

    public boolean getData(String key) {
        return sharedPreferences.getBoolean(key, false);
    }
}
