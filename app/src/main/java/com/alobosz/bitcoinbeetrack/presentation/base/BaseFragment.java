package com.alobosz.bitcoinbeetrack.presentation.base;

import androidx.fragment.app.Fragment;

import com.alobosz.bitcoinbeetrack.util.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

abstract public class BaseFragment extends Fragment implements HasAndroidInjector {
    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

    @Inject
    ViewModelFactory viewModelFactory;
}