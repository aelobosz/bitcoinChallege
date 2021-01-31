package com.alobosz.bitcoinbeetrack.presentation.transactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alobosz.bitcoinbeetrack.databinding.FragmentOrderHistoryBinding;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;
import com.alobosz.bitcoinbeetrack.presentation.MainViewModel;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransactionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressWarnings("rawtypes")
public class TransactionFragment extends BaseFragment {
    private FragmentOrderHistoryBinding binding;
    private TransactionViewModel viewModel;
    private MainViewModel mainViewModel;

    public TransactionFragment() {
        // Required empty public constructor
    }

    public static TransactionFragment newInstance() {
        return new TransactionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationBitcoinWallet.appComponent.inject(this);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(TransactionViewModel.class);
        mainViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOrderHistoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel.getAddress();
        observe();
    }

    @SuppressWarnings("RedundantCast")
    private void observe() {

        mainViewModel.getAddressLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
            switch (result.status) {
                case ERROR:
                    //TODO show error
                    break;
                case SUCCESS:
                    Transactions transactions = (Transactions) result.data;
                    //TODO: setAdapter
                    break;
                case EMPTY:
                    //TODO: show message empty transactions
                    break;
            }
        });

        viewModel.getTransactionLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
            if (null == viewModel.getTransactionLiveData().getValue())
                return;
            switch (result.status) {
                case ERROR:
                    //TODO:show error
                    break;
                case SUCCESS:

                    break;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}