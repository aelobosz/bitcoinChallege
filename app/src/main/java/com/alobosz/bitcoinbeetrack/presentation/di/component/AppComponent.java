package com.alobosz.bitcoinbeetrack.presentation.di.component;

import android.app.Application;

import com.alobosz.bitcoinbeetrack.presentation.di.module.ApiModule;
import com.alobosz.bitcoinbeetrack.presentation.di.module.BaseUrl;
import com.alobosz.bitcoinbeetrack.presentation.di.module.DataBaseModule;
import com.alobosz.bitcoinbeetrack.presentation.di.module.ViewModelModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        DataBaseModule.class,
        ViewModelModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder baseUrl(@BaseUrl String baseUrl);

        AppComponent build();
    }

}
