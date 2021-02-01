package com.alobosz.bitcoinbeetrack.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alobosz.bitcoinbeetrack.data.source.local.model.AddressEntity;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.AddressDTO;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.BalanceDTO;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.TransactionDTO;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;

import java.util.Objects;
import java.util.stream.Collectors;

public class DataMapper {
    public static Address toAddress(AddressDTO addressDTO) {
        return new Address(
                addressDTO.getPrivate(),
                addressDTO.getPublic(),
                addressDTO.getAddress(),
                addressDTO.getWif()
        );

    }

    public static AddressEntity toEntity(Address address) {
        return new AddressEntity(
                address.getAddress(),
                address.get_private(),
                address.get_public(),
                address.getWif()
        );
    }

    public static Address entityToAddress(AddressEntity addressEntity) {
        return new Address(addressEntity.getPrivateKey(),
                addressEntity.getPublicKey(),
                addressEntity.getWalletAddress(),
                addressEntity.getWif()

        );
    }

    public static Balance toBalance(BalanceDTO balanceDTO) {
        return new Balance(
                balanceDTO.getAddress(),
                balanceDTO.getBalance() == null ? "0" : Integer.toString(balanceDTO.getBalance()),
                balanceDTO.getUnconfirmedBalance() == null ? "0" : Integer.toString(balanceDTO.getUnconfirmedBalance()),
                balanceDTO.getFinalBalance() == null ? "0" : Integer.toString(balanceDTO.getFinalBalance()));

    }

    public static Transactions.Transaction toTransaction(TransactionDTO.Tx tx) {
        return new Transactions.Transaction(
                tx.getConfirmed(), tx.getTotal() == null ? "0" : Long.toString(tx.getTotal()));

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Transactions toTransactions(TransactionDTO transactionDTO) {
        return new Transactions(
                transactionDTO.getTxs().stream()
                        .filter(Objects::nonNull)
                        .map(DataMapper::toTransaction)
                        .collect(Collectors.toList()));

    }
}
