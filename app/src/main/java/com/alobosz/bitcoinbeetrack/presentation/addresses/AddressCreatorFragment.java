package com.alobosz.bitcoinbeetrack.presentation.addresses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.databinding.FragmentAddressCreatorBinding;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddressCreatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddressCreatorFragment extends Fragment {
    private FragmentAddressCreatorBinding binding;

    public AddressCreatorFragment() {
        // Required empty public constructor
    }

    public static AddressCreatorFragment newInstance() {
        return new AddressCreatorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationBitcoinWallet.appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddressCreatorBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}