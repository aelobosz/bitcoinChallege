package com.alobosz.bitcoinbeetrack.presentation.transactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.databinding.FragmentTransactionBinding;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;
import com.alobosz.bitcoinbeetrack.presentation.MainViewModel;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;
import com.alobosz.bitcoinbeetrack.presentation.base.Status;
import com.alobosz.bitcoinbeetrack.presentation.transactions.adapter.AdapterTransaction;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransactionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressWarnings("rawtypes")
public class TransactionFragment extends BaseFragment {
    AdapterTransaction adapter;
    private FragmentTransactionBinding binding;
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
        adapter = new AdapterTransaction();
        viewModel = new ViewModelProvider(this, viewModelFactory).get(TransactionViewModel.class);
        mainViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTransactionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.transactionList.setAdapter(adapter);
        binding.swiperefresh.setColorSchemeColors(
                ContextCompat.getColor(
                        requireContext(),
                        R.color.colorAccent));
        mainViewModel.getAddress();
        binding.swiperefresh.setOnRefreshListener(
                () -> mainViewModel.getAddress()
        );
        binding.error.retry.setOnClickListener(v -> {
            binding.swiperefresh.setRefreshing(true);
            mainViewModel.getAddress();
        });
        observe();
    }

    private void observe() {

        mainViewModel.getAddressLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
            if (result.status == Status.SUCCESS) {
                Address address = (Address) result.data;
                if (address != null) {
                    viewModel.getTransactions(address.getAddress());
                }
            }
        });

        viewModel.getTransactionLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
            if (null == viewModel.getTransactionLiveData().getValue())
                return;
            switch (result.status) {
                case SUCCESS:
                    showVisibilityByState(false, false);
                    Transactions transactions = (Transactions) result.data;
                    adapter.refreshAdapter(Objects.requireNonNull(transactions).getTransactions());
                    break;
                case EMPTY:
                    hideSwipeRefresh();
                    adapter.refreshAdapter(new ArrayList<>());
                    showVisibilityByState(false, true);
                    break;
                case ERROR:
                    hideSwipeRefresh();
                    showVisibilityByState(true, false);
                    break;
            }
        });
    }

    private void showVisibilityByState(
            boolean error,
            boolean empty) {
        hideSwipeRefresh();
        binding.progress.getRoot().setVisibility(View.GONE);
        binding.empty.getRoot().setVisibility(empty ? View.VISIBLE : View.GONE);
        binding.error.getRoot().setVisibility(error ? View.VISIBLE : View.GONE);
    }

    private void hideSwipeRefresh() {
        if (binding.swiperefresh.isRefreshing()) {
            binding.swiperefresh.setRefreshing(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}