package com.alobosz.bitcoinbeetrack.di.module;

import com.alobosz.bitcoinbeetrack.presentation.MainActivity;
import com.alobosz.bitcoinbeetrack.presentation.addresses.AddressCreatorFragment;
import com.alobosz.bitcoinbeetrack.presentation.transactions.OrderHistoryFragment;
import com.alobosz.bitcoinbeetrack.presentation.wallet.WalletFragment;

public interface ViewInjector {

    void inject(AddressCreatorFragment addressCreatorFragment);

    void inject(OrderHistoryFragment orderHistoryFragment);

    void inject(WalletFragment walletFragment);

    void inject(MainActivity mainActivity);

}
