package com.alobosz.bitcoinbeetrack.presentation;

import androidx.multidex.MultiDexApplication;

import com.alobosz.bitcoinbeetrack.BuildConfig;
import com.alobosz.bitcoinbeetrack.di.component.AppComponent;
import com.alobosz.bitcoinbeetrack.di.component.DaggerAppComponent;

public class ApplicationBitcoinWallet extends MultiDexApplication {
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .context(this)
                .baseUrl(BuildConfig.BASE_URL)
                .build();
    }
}