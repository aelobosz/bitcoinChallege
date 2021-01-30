package com.alobosz.bitcoinbeetrack.presentation.wallet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.usecase.GetAddressUseCase;
import com.alobosz.bitcoinbeetrack.domain.usecase.GetBalanceUseCase;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;

import java.util.Objects;

import javax.inject.Inject;

import static com.alobosz.bitcoinbeetrack.util.FunUtil.fromConsumer;

@SuppressWarnings("rawtypes")
public class WalletViewModel extends ViewModel {
    private final GetBalanceUseCase getBalanceUseCase;

    @Inject
    public WalletViewModel(
            GetBalanceUseCase getBalanceUseCase,
            GetAddressUseCase getAddressUseCase) {
        this.getBalanceUseCase = getBalanceUseCase;
    }

    private final MutableLiveData<Result> _getBalanceLiveData = new MutableLiveData<>();

    public LiveData<Result> getBalanceLiveData() {
        return _getBalanceLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        getBalanceUseCase.dispose();
    }

    public void getBalance(String Address) {
        getBalanceUseCase.setAddress((Address));
        getBalanceUseCase.execute(
                fromConsumer((Object id) ->
                        _getBalanceLiveData.postValue(Result.success(id))
                ),
                fromConsumer((Throwable onError) -> {
                            if (Objects.requireNonNull(_getBalanceLiveData.getValue()).data == null)
                                _getBalanceLiveData.postValue(Result.error(onError));
                        }

                )
        );


    }
}