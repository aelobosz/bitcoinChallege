package com.alobosz.bitcoinbeetrack.presentation.addresses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;
import com.alobosz.bitcoinbeetrack.domain.usecase.GenerateAddressUseCase;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;

import javax.inject.Inject;

import static com.alobosz.bitcoinbeetrack.util.FunUtil.fromConsumer;

@SuppressWarnings("ALL")
public class AddressViewModel extends ViewModel {
    private final GenerateAddressUseCase generateAddressUseCase;

    private MutableLiveData<Result> _generateAddressLiveData = new MutableLiveData<>();

    public LiveData<Result> generateAddressLiveData() {
        return _generateAddressLiveData;
    }


    @Inject
    public AddressViewModel(GenerateAddressUseCase generateAddressUseCase) {
        this.generateAddressUseCase = generateAddressUseCase;
    }

    public void generateAddress() {
        _generateAddressLiveData.postValue(Result.loading());
        generateAddressUseCase.execute(
                fromConsumer((Address address) ->
                        _generateAddressLiveData.postValue(Result.success(address))
                ),
                fromConsumer((Throwable onError) ->
                        _generateAddressLiveData.postValue(Result.error(onError))
                )
        );
    }

    public void saveAddress(String text) {

    }
}