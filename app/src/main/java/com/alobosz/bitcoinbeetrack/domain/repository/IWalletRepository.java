package com.alobosz.bitcoinbeetrack.domain.repository;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;

import io.reactivex.Single;
import io.reactivex.Single;

public interface IWalletRepository {
    Single<Address> generateAddress();
}
