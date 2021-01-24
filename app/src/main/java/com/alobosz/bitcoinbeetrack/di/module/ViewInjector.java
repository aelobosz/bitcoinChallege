package com.alobosz.bitcoinbeetrack.di.module;

import com.alobosz.bitcoinbeetrack.presentation.MainActivity;
import com.alobosz.bitcoinbeetrack.presentation.addresses.AddressFragment;
import com.alobosz.bitcoinbeetrack.presentation.transactions.OrderFragment;
import com.alobosz.bitcoinbeetrack.presentation.wallet.WalletFragment;

public interface ViewInjector {

    void inject(AddressFragment addressFragment);

    void inject(OrderFragment orderFragment);

    void inject(WalletFragment walletFragment);

    void inject(MainActivity mainActivity);

}
