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
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;
import com.alobosz.bitcoinbeetrack.presentation.MainViewModel;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;
import com.alobosz.bitcoinbeetrack.util.QrGenerator;

import org.jetbrains.annotations.NotNull;

import static com.alobosz.bitcoinbeetrack.util.ClipBoardUtil.copyToClipboard;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WalletFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WalletFragment extends BaseFragment {

    private FragmentWalletBinding binding;
    private WalletViewModel viewModel;
    private MainViewModel mainViewModel;


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
        mainViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel.class);
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
        binding.walletAddressContainer.clipboard.setOnClickListener(v ->
                copyToClipboard(
                        getContext(),
                        binding.walletAddressContainer.walletAddress.getText().toString()));
        mainViewModel.getAddress();
    }

    @SuppressWarnings("rawtypes")
    private void observe() {
        mainViewModel.getAddressLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
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
                        viewModel.getBalance(address.getAddress());
                    }
                    break;
            }
        });

        viewModel.getBalanceLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
            if (null == viewModel.getBalanceLiveData().getValue())
                return;
            switch (result.status) {
                case ERROR:
                    binding.cardBalance.smallProgress.setVisibility(View.GONE);
                    //TODO:show error
                    break;
                case SUCCESS:
                    binding.cardBalance.smallProgress.setVisibility(View.GONE);

                    Balance balance = (Balance) result.data;
                    if (null == balance)
                        return;
                    binding.cardBalance.balance.setText(balance.getBalance());
                    binding.cardBalance.unconfinedBalance.setText(balance.getUnconfirmedBalance());
                    binding.cardBalance.finalBalance.setText(balance.getFinalBalance());
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