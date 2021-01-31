package com.alobosz.bitcoinbeetrack.di.module;

import android.app.Application;

import androidx.appcompat.app.AlertDialog;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.presentation.MainActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GlideModule {

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions(){
        return RequestOptions
                .placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }

    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions){
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }
}
