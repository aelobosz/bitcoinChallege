package com.alobosz.bitcoinbeetrack.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.util.PreferencesConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }

    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Context context, RequestOptions requestOptions) {
        return Glide.with(context)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPrefences(Context context) {
        return context.getSharedPreferences(PreferencesConstants.PREF_FILE, Context.MODE_PRIVATE);
    }

}
