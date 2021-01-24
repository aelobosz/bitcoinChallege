package com.alobosz.bitcoinbeetrack.presentation.addresses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.domain.usecase.GetAddressUseCase;

import javax.inject.Inject;

public class AddressViewModel extends ViewModel {
    private GetAddressUseCase getAddressUseCase;

    private MutableLiveData<String> mText;
    public LiveData<String> getText() {
        return mText;
    }

    @Inject
    public AddressViewModel(GetAddressUseCase getAddressUseCase) {
        this.getAddressUseCase = getAddressUseCase;
    }


}