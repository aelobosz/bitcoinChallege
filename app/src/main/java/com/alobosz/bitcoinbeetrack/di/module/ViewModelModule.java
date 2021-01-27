package com.alobosz.bitcoinbeetrack.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.alobosz.bitcoinbeetrack.di.util.ViewModelKey;
import com.alobosz.bitcoinbeetrack.presentation.MainViewModel;
import com.alobosz.bitcoinbeetrack.presentation.addresses.AddressViewModel;
import com.alobosz.bitcoinbeetrack.presentation.transactions.TransactionViewModel;
import com.alobosz.bitcoinbeetrack.presentation.wallet.WalletViewModel;
import com.alobosz.bitcoinbeetrack.util.ViewModelFactory;


import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract public class ViewModelModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindUserViewModel(MainViewModel userViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AddressViewModel.class)
    abstract ViewModel bindAddressViewModel(AddressViewModel addressViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TransactionViewModel.class)
    abstract ViewModel bindTransactionViewModel(TransactionViewModel transactionViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WalletViewModel.class)
    abstract ViewModel bindWalletViewModel(WalletViewModel walletViewModel);


}
