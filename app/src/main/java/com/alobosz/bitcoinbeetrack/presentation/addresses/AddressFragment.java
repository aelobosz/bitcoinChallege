package com.alobosz.bitcoinbeetrack.presentation.addresses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alobosz.bitcoinbeetrack.databinding.FragmentAddressCreatorBinding;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddressFragment extends BaseFragment {

    private FragmentAddressCreatorBinding binding;
    private AddressViewModel viewModel;

    public AddressFragment() {
        // Required empty public constructor
    }

    public static AddressFragment newInstance() {
        return new AddressFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationBitcoinWallet.appComponent.inject(this);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(AddressViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddressCreatorBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.isLoad().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                binding.progress.getRoot().setVisibility(isLoading ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.generateAddress();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}