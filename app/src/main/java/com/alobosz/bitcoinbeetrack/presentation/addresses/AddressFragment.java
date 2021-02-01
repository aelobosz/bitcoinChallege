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
import com.alobosz.bitcoinbeetrack.presentation.MainViewModel;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;
import com.alobosz.bitcoinbeetrack.presentation.base.Status;
import com.alobosz.bitcoinbeetrack.util.PreferencesConstants;
import com.alobosz.bitcoinbeetrack.util.QrGenerator;
import com.alobosz.bitcoinbeetrack.util.WalletPreferences;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import javax.inject.Inject;

import static androidx.navigation.fragment.NavHostFragment.findNavController;
import static com.alobosz.bitcoinbeetrack.util.ClipBoardUtil.copyToClipboard;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressWarnings("RedundantCast")
public class AddressFragment extends BaseFragment {
    @Inject
    WalletPreferences walletPreferences;

    private FragmentAddressCreatorBinding binding;
    private AddressViewModel viewModel;
    private MainViewModel mainViewModel;

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
        mainViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel.class);
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

        binding.walletAddressContainer.clipboard.setOnClickListener(v ->
                copyToClipboard(
                        getContext(),
                        binding.walletAddressContainer.walletAddress.getText().toString()
                )
        );
        binding.materialButton.setOnClickListener(v -> viewModel.generateAddress());
        binding.save.setOnClickListener(v -> viewModel.saveAddress());
        binding.error.retry.setOnClickListener(v -> viewModel.generateAddress());
    }

    @SuppressWarnings("rawtypes")
    private void observe() {
        viewModel.generateAddressLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
            switch (result.status) {
                case LOADING:
                    binding.progress.getRoot().setVisibility(View.VISIBLE);
                    binding.error.getRoot().setVisibility(View.GONE);
                    break;
                case SUCCESS:
                    Address address = (Address) result.data;
                    binding.progress.getRoot().setVisibility(View.GONE);
                    binding.error.getRoot().setVisibility(View.GONE);
                    if (address != null) {
                        binding.walletView.imageQR.setImageBitmap(QrGenerator.createQR(
                                address.getAddress(), 150, 150));
                        binding.walletAddressContainer.walletAddress.setText(address.getAddress());
                    }
                    break;
                default:
                    binding.error.getRoot().setVisibility(View.VISIBLE);
                    binding.progress.getRoot().setVisibility(View.GONE);
                    break;
            }
        });

        viewModel.saveAddressLiveData().observe(getViewLifecycleOwner(), (Observer<Result>) result -> {
            switch (result.status) {
                case LOADING:
                    binding.progress.getRoot().setVisibility(View.VISIBLE);
                    break;
                case SUCCESS: {
                    saveHasWallet();
                    viewModel.generateAddress();
                    findNavController(this).navigate(R.id.action_addressFragment_to_successFragment);
                }
                break;
                default:
                    binding.progress.getRoot().setVisibility(View.GONE);
            }
        });

    }

    private void saveHasWallet() {
        walletPreferences.saveData(PreferencesConstants.HAS_ADDRESS_KEY, true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}