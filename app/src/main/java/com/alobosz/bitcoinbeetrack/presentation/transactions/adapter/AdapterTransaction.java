package com.alobosz.bitcoinbeetrack.presentation.transactions.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alobosz.bitcoinbeetrack.databinding.RowTransactionBinding;
import com.alobosz.bitcoinbeetrack.domain.model.Transactions;

import java.util.List;

public class AdapterTransaction extends RecyclerView.Adapter<ViewHolderTransaction> {
    private List<Transactions.Transaction> transactions;

    public AdapterTransaction() {
    }

    @NonNull
    @Override
    public ViewHolderTransaction onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RowTransactionBinding binding = RowTransactionBinding.inflate(layoutInflater);
        binding.getRoot().setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));

        return new ViewHolderTransaction(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTransaction holder, int position) {
        holder.bind(transactions.get(position));
    }

    @Override
    public int getItemCount() {
        return transactions != null ? transactions.size() : 0;
    }

    public void refreshAdapter(List<Transactions.Transaction> transactions) {
        this.transactions = transactions;
        notifyDataSetChanged();

    }
}
