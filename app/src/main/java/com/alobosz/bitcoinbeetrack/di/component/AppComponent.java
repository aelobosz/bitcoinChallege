package com.alobosz.bitcoinbeetrack.di.component;

import android.content.Context;

import com.alobosz.bitcoinbeetrack.di.module.ApiModule;
import com.alobosz.bitcoinbeetrack.di.module.DataBaseModule;
import com.alobosz.bitcoinbeetrack.di.module.AppModule;
import com.alobosz.bitcoinbeetrack.di.module.RepositoryModule;
import com.alobosz.bitcoinbeetrack.di.module.ViewModelModule;
import com.alobosz.bitcoinbeetrack.di.util.BaseUrl;
import com.alobosz.bitcoinbeetrack.di.util.InjectViews;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        DataBaseModule.class,
        ViewModelModule.class,
        RepositoryModule.class,
        AppModule.class
})
public interface AppComponent extends InjectViews {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder baseUrl(@BaseUrl String baseUrl);

        AppComponent build();
    }
}
