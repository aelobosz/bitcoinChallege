package com.alobosz.bitcoinbeetrack.di.component;

import android.app.Application;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder baseUrl(@Named("baseUrl") String baseUrl);

        AppComponent build();
    }

}
