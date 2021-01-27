package com.alobosz.bitcoinbeetrack.di.util;

import com.alobosz.bitcoinbeetrack.presentation.MainActivity;
import com.alobosz.bitcoinbeetrack.presentation.addresses.AddressFragment;
import com.alobosz.bitcoinbeetrack.presentation.transactions.TransactionFragment;
import com.alobosz.bitcoinbeetrack.presentation.wallet.WalletFragment;

public interface InjectViews {
    void inject(MainActivity mainActivity);
    void inject(AddressFragment addressFragment);
    void inject(WalletFragment walletFragment);
    void inject(TransactionFragment transactionFragment);
}
