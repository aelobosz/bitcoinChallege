package com.alobosz.bitcoinbeetrack.presentation.addresses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.databinding.FragmentSuccessBinding;
import com.alobosz.bitcoinbeetrack.presentation.MainActivity;
import com.alobosz.bitcoinbeetrack.presentation.MainViewModel;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseFragment;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SuccessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SuccessFragment extends BaseFragment {
    FragmentSuccessBinding binging;
    private MainViewModel mainViewModel;


    public SuccessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SuccessFragment.
     */
    public static SuccessFragment newInstance() {
        return new SuccessFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binging = FragmentSuccessBinding.inflate(inflater, container, false);
        return binging.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binging.back.setOnClickListener(v -> requireActivity().onBackPressed());
        binging.goToWallet.setOnClickListener(v -> {
                    mainViewModel.selectItem(R.id.wallet);
                    requireActivity().onBackPressed();
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binging = null;
    }
}