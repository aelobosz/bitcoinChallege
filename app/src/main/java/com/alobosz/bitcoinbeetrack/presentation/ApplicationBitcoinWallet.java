package com.alobosz.bitcoinbeetrack.presentation;

import android.app.Application;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.di.component.AppComponent;
import com.alobosz.bitcoinbeetrack.di.component.DaggerAppComponent;

public class ApplicationBitcoinWallet extends Application {
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
      appComponent =  DaggerAppComponent.builder()
                .application(this)
                .baseUrl(getString(R.string.base_url))
                .build();
    }
}
