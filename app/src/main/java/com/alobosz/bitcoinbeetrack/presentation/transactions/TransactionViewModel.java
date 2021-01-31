package com.alobosz.bitcoinbeetrack.presentation.transactions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alobosz.bitcoinbeetrack.domain.model.Transactions;
import com.alobosz.bitcoinbeetrack.domain.usecase.GetTransactionsUseCase;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;

import java.util.Objects;

import javax.inject.Inject;

import static com.alobosz.bitcoinbeetrack.util.FunUtil.fromConsumer;

@SuppressWarnings("rawtypes")
public class TransactionViewModel extends ViewModel {
    private GetTransactionsUseCase getTransactionsUseCase;

    private final MutableLiveData<Result> _getTransactionLiveData = new MutableLiveData<>();

    public LiveData<Result> getTransactionLiveData() {
        return _getTransactionLiveData;
    }

    @Inject
    public TransactionViewModel(GetTransactionsUseCase getTransactionsUseCase) {
        this.getTransactionsUseCase = getTransactionsUseCase;
    }


    public void getTransactions(String Address) {
        getTransactionsUseCase.setAddress((Address));
        getTransactionsUseCase.execute(
                fromConsumer((Transactions transactions) -> {
                            if (transactions.getTransactions().isEmpty())
                                _getTransactionLiveData.postValue(Result.onEmpty());
                            else
                                _getTransactionLiveData.postValue(Result.onSuccess(transactions));
                        }
                ),
                fromConsumer((Throwable onError) -> {
                            if (Objects.requireNonNull(_getTransactionLiveData.getValue()).data == null)
                                _getTransactionLiveData.postValue(Result.onError(onError));
                        }
                )
        );
    }
}