package com.alobosz.bitcoinbeetrack.presentation.wallet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.usecase.GetAddressUseCase;
import com.alobosz.bitcoinbeetrack.domain.usecase.GetBalanceUseCase;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;

import javax.inject.Inject;

import static com.alobosz.bitcoinbeetrack.util.FunUtil.fromConsumer;

@SuppressWarnings("rawtypes")
public class WalletViewModel extends ViewModel {
    private GetBalanceUseCase getBalanceUseCase;
    private GetAddressUseCase getAddressUseCase;

    @Inject
    public WalletViewModel(
            GetBalanceUseCase getBalanceUseCase,
            GetAddressUseCase getAddressUseCase) {
        this.getBalanceUseCase = getBalanceUseCase;
    }

    private final MutableLiveData<Result> _getAddressLiveData = new MutableLiveData<>();

    public LiveData<Result> getAddressLiveData() {
        return _getAddressLiveData;
    }

    public void saveAddress(String addressString) {
        _getAddressLiveData.postValue(Result.loading());
        getAddressUseCase.getAddress(addressString);
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
        getBalanceUseCase.dispose();
    }

}