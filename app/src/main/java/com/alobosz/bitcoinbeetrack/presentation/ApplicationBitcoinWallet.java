package com.alobosz.bitcoinbeetrack.presentation;

import android.app.Application;

import com.alobosz.bitcoinbeetrack.BuildConfig;
import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.di.component.AppComponent;
import com.alobosz.bitcoinbeetrack.di.component.DaggerAppComponent;

import androidx.multidex.MultiDexApplication;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

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