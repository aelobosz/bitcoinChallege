package com.alobosz.bitcoinbeetrack.util;

import com.alobosz.bitcoinbeetrack.data.source.local.model.AddressEntity;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.AddressDTO;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.BalanceDTO;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.TransactionDTO;
import com.alobosz.bitcoinbeetrack.domain.model.Address;
import com.alobosz.bitcoinbeetrack.domain.model.Balance;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;

import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataMapper {
    private static final Integer satoshi = 100000000;
    private static final String zero = "0";

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
                balanceDTO.getBalance() == null ? zero : String.format(
                        Locale.getDefault(), "%.8f BTC", balanceDTO.getBalance() / satoshi),
                balanceDTO.getUnconfirmedBalance() == null ? zero : String.format(
                        Locale.getDefault(), "%.8f BTC", balanceDTO.getUnconfirmedBalance() / satoshi),
                balanceDTO.getFinalBalance() == null ? zero : String.format(
                        Locale.getDefault(), "%.8f BTC", balanceDTO.getFinalBalance() / satoshi));

    }

    public static Transactions.Transaction toTransaction(TransactionDTO.Tx tx) {
        return new Transactions.Transaction(
                tx.getConfirmed(),
                getSatochisFromTransaction(tx)
        );

    }


    public static Transactions toTransactions(TransactionDTO transactionDTO) {
        return new Transactions(
                transactionDTO.getTxs().stream()
                        .filter(Objects::nonNull)
                        .map(DataMapper::toTransaction)
                        .collect(Collectors.toList()));

    }

    private static String getSatochisFromTransaction(TransactionDTO.Tx tx) {
        try {
            return String.format(Locale.getDefault(), "%.8f", tx.getOutputs().get(1).getValue() / satoshi);
        } catch (Throwable t) {
            return "indeterminate";
        }


    }
}
