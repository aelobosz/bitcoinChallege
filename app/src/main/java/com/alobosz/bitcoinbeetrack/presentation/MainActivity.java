package com.alobosz.bitcoinbeetrack.presentation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import com.alobosz.bitcoinbeetrack.R;
import com.alobosz.bitcoinbeetrack.databinding.ActivityMainBinding;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.presentation.base.BaseActivity;
import com.alobosz.bitcoinbeetrack.presentation.base.Result;
import com.alobosz.bitcoinbeetrack.presentation.base.Status;
import com.alobosz.bitcoinbeetrack.util.NavigationExtensionsKt;
import com.alobosz.bitcoinbeetrack.util.PreferencesConstants;
import com.alobosz.bitcoinbeetrack.util.QrGenerator;
import com.alobosz.bitcoinbeetrack.util.WalletPreferences;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import static com.alobosz.bitcoinbeetrack.util.FunUtil.fromConsumer;
import static com.alobosz.bitcoinbeetrack.util.NavigationExtensionsKt.setupWithNavController;

public class MainActivity extends BaseActivity {

    @Inject
    WalletPreferences walletPreferences;
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
        if (savedInstanceState == null)
            setupBottomNavigationBar();

        if (hasAddress())
            selectBottomNavItem(R.id.wallet);

        observe();
        mainViewModel.getAddress();


    }

    @SuppressWarnings("rawtypes")
    private void observe() {
        mainViewModel.getSelectedItemLiveData().observe(
                this, this::selectBottomNavItem);
        mainViewModel.getAddressLiveData().observe(
                this, (Observer<Result>) result -> {
                    if (result.status == Status.EMPTY &&
                            binding.bottomNav.getSelectedItemId() != R.id.address)
                        selectBottomNavItem(R.id.address);
                });
    }

    private void selectBottomNavItem(int itemId) {
        if (R.id.address == itemId)
            NavigationExtensionsKt.showIndefiniteSnackBar(
                    this,
                    R.string.no_address_message,
                    binding.getRoot()).show();
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

    private boolean hasAddress() {
        return walletPreferences.getData(PreferencesConstants.HAS_ADDRESS_KEY);
    }

}