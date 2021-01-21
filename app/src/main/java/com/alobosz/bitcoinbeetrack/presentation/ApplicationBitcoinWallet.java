package com.alobosz.bitcoinbeetrack.presentation;

import android.app.Application;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.presentation.di.component.DaggerAppComponent;

public class ApplicationBitcoinWallet extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .baseUrl(getString(R.string.base_url))
                .build();
    }
}
