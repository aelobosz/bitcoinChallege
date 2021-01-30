package com.alobosz.bitcoinbeetrack.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.usecase.GetAddressUseCase;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;

import javax.inject.Inject;

import static com.alobosz.bitcoinbeetrack.util.FunUtil.fromConsumer;

@SuppressWarnings("rawtypes")
public class MainViewModel extends ViewModel {
    private final GetAddressUseCase getAddressUseCase;

    @Inject
    public MainViewModel(
            GetAddressUseCase getAddressUseCase) {
        this.getAddressUseCase = getAddressUseCase;
    }

    private final MutableLiveData<Result> _getAddressLiveData = new MutableLiveData<>();

    public LiveData<Result> getAddressLiveData() {
        return _getAddressLiveData;
    }

    public void getAddress() {
        _getAddressLiveData.postValue(Result.loading());
        getAddressUseCase.setAddress(null);
        getAddressUseCase.execute(
                fromConsumer((Address address) ->
                        _getAddressLiveData.postValue(Result.success(address))
                ),
                fromConsumer((Throwable onError) ->
                        _getAddressLiveData.postValue(Result.error(onError))
                )
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        getAddressUseCase.dispose();
    }


}
