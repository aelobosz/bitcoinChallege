package com.alobosz.bitcoinbeetrack.presentation.wallet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.domain.usecase.GetBalanceUseCase;

import javax.inject.Inject;

public class WalletViewModel extends ViewModel {
    @Inject
    public WalletViewModel(GetBalanceUseCase useCase){

    }
}