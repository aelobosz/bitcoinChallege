package com.alobosz.bitcoinbeetrack.presentation.transactions.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.alobosz.bitcoinbeetrack.databinding.RowTransactionBinding;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;

public class ViewHolderTransaction extends RecyclerView.ViewHolder {
    RowTransactionBinding binding;

    public ViewHolderTransaction(RowTransactionBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(Transactions.Transaction transaction) {
        binding.total.setText(transaction.getTotal());
        binding.date.setText(transaction.getDate());
    }
}
