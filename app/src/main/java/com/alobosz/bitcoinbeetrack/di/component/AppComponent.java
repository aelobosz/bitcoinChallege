package com.alobosz.bitcoinbeetrack.di.component;

import android.app.Application;

import com.alobosz.bitcoinbeetrack.di.module.ApiModule;
import com.alobosz.bitcoinbeetrack.di.module.BaseUrl;
import com.alobosz.bitcoinbeetrack.di.module.DataBaseModule;
import com.alobosz.bitcoinbeetrack.di.module.ViewInjector;
import com.alobosz.bitcoinbeetrack.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        DataBaseModule.class,
        ViewModelModule.class
})
public interface AppComponent extends ViewInjector{
    @SuppressWarnings("UnusedReturnValue")
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder baseUrl(@BaseUrl String baseUrl);

        AppComponent build();
    }

}
