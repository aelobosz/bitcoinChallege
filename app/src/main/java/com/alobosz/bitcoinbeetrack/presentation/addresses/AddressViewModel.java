package com.alobosz.bitcoinbeetrack.presentation.addresses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.usecase.GenerateAddressUseCase;
import com.alobosz.bitcoinbeetrack.domain.usecase.SaveAddressUseCase;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;
import com.alobosz.bitcoinbeetrack.util.SingleLiveEvent;

import javax.inject.Inject;

import static com.alobosz.bitcoinbeetrack.util.FunUtil.fromConsumer;

@SuppressWarnings("rawtypes")
public class AddressViewModel extends ViewModel {
    private final GenerateAddressUseCase generateAddressUseCase;
    private final SaveAddressUseCase saveAddressUseCase;

    private final MutableLiveData<Result> _generateAddressLiveData = new MutableLiveData<>();

    public LiveData<Result> generateAddressLiveData() {
        return _generateAddressLiveData;
    }

    private final SingleLiveEvent<Result> _saveAddressLiveData = new SingleLiveEvent<>();

    public LiveData<Result> saveAddressLiveData() {
        return _saveAddressLiveData;
    }


    @Inject
    public AddressViewModel(GenerateAddressUseCase generateAddressUseCase,
                            SaveAddressUseCase saveAddressUseCase) {
        this.generateAddressUseCase = generateAddressUseCase;
        this.saveAddressUseCase = saveAddressUseCase;
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

    public void saveAddress() {
        if (_generateAddressLiveData.getValue() == null)
            return;
        _saveAddressLiveData.postValue(Result.loading());
        saveAddressUseCase.saveAddress((Address) _generateAddressLiveData.getValue().data);
        saveAddressUseCase.execute(
                fromConsumer((Object id) ->
                        _saveAddressLiveData.postValue(Result.success(id))
                ),
                fromConsumer((Throwable onError) ->
                        _generateAddressLiveData.postValue(Result.error(onError))
                )
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        generateAddressUseCase.dispose();
        saveAddressUseCase.dispose();
    }
}
