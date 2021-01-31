package com.alobosz.bitcoinbeetrack.presentation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.databinding.ActivityMainBinding;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseActivity;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;
import com.alobosz.bitcoinbeetrack.presentation.base.Status;
import com.alobosz.bitcoinbeetrack.util.NavigationExtensionsKt;
import com.alobosz.bitcoinbeetrack.util.QrGenerator;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import static com.alobosz.bitcoinbeetrack.util.FunUtil.fromConsumer;
import static com.alobosz.bitcoinbeetrack.util.NavigationExtensionsKt.setupWithNavController;

public class MainActivity extends BaseActivity {

    @Inject
    MainViewModel mainViewModel;
    ActivityMainBinding binding;
    private LiveData<NavController> currentNavController = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationBitcoinWallet.appComponent.inject(this);
        mainViewModel = new ViewModelProvider(this, viewModelFactory).get(MainViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        if (savedInstanceState == null) {
            setupBottomNavigationBar();
        }
        observe();
        mainViewModel.getAddress();


    }

    @SuppressWarnings("rawtypes")
    private void observe() {
        mainViewModel.getSelectedItemLiveData().observe(
                this, this::selectBottomNavItem);
        mainViewModel.getAddressLiveData().observe(
                this, (Observer<Result>) result -> {
                    //if (result.status == Status.SUCCESS)
                    //binding.bottomNav.setSelectedItemId(R.id.wallet);
                });
    }

    private void selectBottomNavItem(int itemId) {
        if (R.id.address == itemId)
            showDialog();
        binding.bottomNav.setSelectedItemId(itemId);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setupBottomNavigationBar();
    }

    /**
     * Called on first creation and when restoring state.
     */
    private void setupBottomNavigationBar() {
        BottomNavigationView bottomNavigationView = binding.bottomNav;

        List<Integer> navGraphIds = new ArrayList<>(Arrays.asList(
                R.navigation.address,
                R.navigation.order,
                R.navigation.wallet));

        // Setup the bottom navigation view with a list of navigation graphs
        LiveData<NavController> controller = setupWithNavController(
                bottomNavigationView,
                navGraphIds,
                getSupportFragmentManager(),
                R.id.nav_host_container,
                getIntent()
        );

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this, new Observer<NavController>() {
            @Override
            public void onChanged(NavController navController) {
                NavigationUI.setupActionBarWithNavController(MainActivity.this, navController);
            }
        });
        currentNavController = controller;
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (null != currentNavController && null != currentNavController.getValue())
            return currentNavController.getValue().navigateUp();
        else return false;
    }

    private void showDialog() {
        NavigationExtensionsKt.showAlertDialog(
                this, fromConsumer((AlertDialog.Builder builder) -> {
                            builder
                                    .setMessage(getString(R.string.no_address_message))
                                    .setTitle(R.string.no_address)
                                    .setPositiveButton(R.string.ok, (dialog, which) -> {
                                    })
                                    .create()
                                    .show();
                        }
                ));
    }

}