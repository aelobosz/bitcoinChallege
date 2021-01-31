package com.alobosz.bitcoinbeetrack.presentation.transactions.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alobosz.bitcoinbeetrack.databinding.RowTransactionBinding;

public class AdapterTransaction extends RecyclerView.Adapter<ViewHolderTransaction>{
    @NonNull
    @Override
    public ViewHolderTransaction onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RowTransactionBinding binding = RowTransactionBinding.inflate(layoutInflater);
        return new ViewHolderTransaction(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTransaction holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
