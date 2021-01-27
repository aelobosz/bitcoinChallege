package com.alobosz.bitcoinbeetrack.presentation.base;

import androidx.fragment.app.Fragment;

import com.alobosz.bitcoinbeetrack.util.ViewModelFactory;

import javax.inject.Inject;

abstract public class BaseFragment extends Fragment{

    @Inject
    public ViewModelFactory viewModelFactory;


}