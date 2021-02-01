package com.alobosz.bitcoinbeetrack.domain.model;

import java.util.List;

public class Transactions {
    private List<Transaction> transactions;

    public Transactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    @SuppressWarnings({"unused", "RedundantSuppression"})
    public static class Transaction {
        private String date;
        private String total;

        public Transaction(String date, String total) {
            this.date = date;
            this.total = total;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }
}

