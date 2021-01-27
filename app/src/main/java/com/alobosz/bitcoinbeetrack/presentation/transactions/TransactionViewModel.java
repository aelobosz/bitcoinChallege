package com.alobosz.bitcoinbeetrack.presentation.transactions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.domain.usecase.GetTransactionsUseCase;

import javax.inject.Inject;

public class TransactionViewModel extends ViewModel {

    @Inject
    public TransactionViewModel(GetTransactionsUseCase useCase){

    }
}