package com.alobosz.bitcoinbeetrack.presentation;

import android.app.Application;

import com.alobosz.bitcoinbeetrack.BuildConfig;
import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.di.component.AppComponent;

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
       /* appComponent = DaggerAppComponent.builder()
                .application(this)
                .baseUrl(BuildConfig.BASE_URL)
                .build();*/
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}