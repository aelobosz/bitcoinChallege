package com.alobosz.bitcoinbeetrack.presentation.transactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.alobosz.bitcoinbeetrack.databinding.FragmentOrderHistoryBinding;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;
import com.alobosz.bitcoinbeetrack.presentation.addresses.AddressViewModel;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransactionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransactionFragment extends BaseFragment {
    private FragmentOrderHistoryBinding binding;
    private TransactionViewModel viewModel;

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOrderHistoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}