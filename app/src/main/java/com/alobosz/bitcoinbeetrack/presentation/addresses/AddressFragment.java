package com.alobosz.bitcoinbeetrack.presentation.addresses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.databinding.FragmentAddressCreatorBinding;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.presentation.ApplicationBitcoinWallet;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;
import com.alobosz.bitcoinbeetrack.presentation.base.Status;
import com.alobosz.bitcoinbeetrack.util.QrGenerator;

import org.jetbrains.annotations.NotNull;

import static com.alobosz.bitcoinbeetrack.util.ClipBoardUtil.copyToClipboard;

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
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddressCreatorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        observe();

        if (viewModel.generateAddressLiveData().getValue() == null
                || viewModel.generateAddressLiveData().getValue().status == Status.ERROR)
            viewModel.generateAddress();

        binding.walletAddressContainer.clipboard.setOnClickListener(v -> {
            Toast.makeText(getContext(), getString(R.string.copied_clipboard), Toast.LENGTH_SHORT).show();
            copyToClipboard(getContext(), binding.walletAddressContainer.walletAddress.getText().toString());

        });
        binding.materialButton.setOnClickListener(v -> viewModel.generateAddress());

        binding.save.setOnClickListener(v -> viewModel.saveAddress());
    }

    @SuppressWarnings("rawtypes")
    private void observe() {
        viewModel.generateAddressLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
            switch (result.status) {
                case LOADING:
                    binding.progress.getRoot().setVisibility(View.VISIBLE);
                    break;
                case SUCCESS:
                    Address address = (Address) result.data;
                    binding.progress.getRoot().setVisibility(View.GONE);
                    if (address != null) {
                        binding.walletView.imageQR.setImageBitmap(QrGenerator.createQR(
                                address.getAddress(), 150, 150));
                        binding.walletAddressContainer.walletAddress.setText(address.getAddress());
                    }
                    break;
                default:
                    binding.progress.getRoot().setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}