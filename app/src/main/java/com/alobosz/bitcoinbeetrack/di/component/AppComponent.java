package com.alobosz.bitcoinbeetrack.di.component;

import android.app.Application;

import com.alobosz.bitcoinbeetrack.di.module.ApiModule;
import com.alobosz.bitcoinbeetrack.di.module.BaseUrl;
import com.alobosz.bitcoinbeetrack.di.module.DataBaseModule;
import com.alobosz.bitcoinbeetrack.di.module.ViewInjector;
import com.alobosz.bitcoinbeetrack.di.module.ViewModelModule;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        ApiModule.class,
        DataBaseModule.class,
        ViewModelModule.class,
        AndroidInjectionModule.class
})
public interface AppComponent extends AndroidInjector<ApplicationBitcoinWallet> {
    @SuppressWarnings("UnusedReturnValue")
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(ApplicationBitcoinWallet application);

        @BindsInstance
        Builder baseUrl(@BaseUrl String baseUrl);

        AppComponent build();
    }

}
