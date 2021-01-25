package com.alobosz.bitcoinbeetrack.presentation.addresses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;
import com.alobosz.bitcoinbeetrack.domain.usecase.GenerateAddressUseCase;

import java.util.function.Function;

import javax.inject.Inject;

import io.reactivex.Single;
import kotlin.Unit;

public class AddressViewModel extends ViewModel {
    private final GenerateAddressUseCase generateAddressUseCase;

    private MutableLiveData<Boolean> load = new MutableLiveData<>();
    public LiveData<Boolean> isLoad() {
        return load;
    }


    @Inject
    public AddressViewModel(GenerateAddressUseCase generateAddressUseCase) {
        this.generateAddressUseCase = generateAddressUseCase;
    }

    public void generateAddress() {
    }


}