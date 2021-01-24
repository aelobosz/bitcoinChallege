package com.alobosz.bitcoinbeetrack.presentation;

import android.app.Application;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.di.component.AppComponent;
import com.alobosz.bitcoinbeetrack.di.component.DaggerAppComponent;
import androidx.multidex.MultiDexApplication;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class ApplicationBitcoinWallet extends MultiDexApplication implements HasAndroidInjector {
    public static AppComponent appComponent;
    @Inject
    DispatchingAndroidInjector<Object> androidInjector;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent =  DaggerAppComponent.builder()
                .application(this)
                .baseUrl("https://google.com")
                .build();
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}