package com.alobosz.bitcoinbeetrack.presentation.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alobosz.bitcoinbeetrack.util.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

abstract public class BaseFragment extends Fragment{

    @Inject
    public ViewModelFactory viewModelFactory;

}