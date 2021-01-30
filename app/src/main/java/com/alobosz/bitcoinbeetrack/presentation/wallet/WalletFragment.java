package com.alobosz.bitcoinbeetrack.presentation.wallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alobosz.bitcoinbeetrack.databinding.FragmentWalletBinding;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;
import com.alobosz.bitcoinbeetrack.presentation.addresses.AddressViewModel;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;
import com.alobosz.bitcoinbeetrack.util.QrGenerator;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WalletFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WalletFragment extends BaseFragment {

    private FragmentWalletBinding binding;
    private WalletViewModel viewModel;

    public WalletFragment() {
        // Required empty public constructor
    }

    public static WalletFragment newInstance() {
        return new WalletFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationBitcoinWallet.appComponent.inject(this);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(WalletViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWalletBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        observe();
        viewModel.getAddress();

    }

    private void observe() {
        viewModel.getAddressLiveData().observe(getViewLifecycleOwner(), (Observer<Result>)result -> {
            switch (result.status) {
                case LOADING:
                    //binding.progress.getRoot().setVisibility(View.VISIBLE);
                    break;
                case SUCCESS:
                    Address address = (Address) result.data;
                    //binding.progress.getRoot().setVisibility(View.GONE);
                    if (address != null) {
                        binding.walletView.imageQR.setImageBitmap(QrGenerator.createQR(
                                address.getAddress(), 150, 150));
                        binding.walletAddressContainer.walletAddress.setText(address.getAddress());
                    }
                    break;
                default:
                    //binding.progress.getRoot().setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}