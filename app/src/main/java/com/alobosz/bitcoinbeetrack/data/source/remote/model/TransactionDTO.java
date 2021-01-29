package com.alobosz.bitcoinbeetrack.data.source.remote.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("ALL")
public class TransactionDTO {
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("total_received")
    @Expose
    private Integer totalReceived;
    @SerializedName("total_sent")
    @Expose
    private Integer totalSent;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("unconfirmed_balance")
    @Expose
    private Integer unconfirmedBalance;
    @SerializedName("final_balance")
    @Expose
    private Integer finalBalance;
    @SerializedName("n_tx")
    @Expose
    private Integer nTx;
    @SerializedName("unconfirmed_n_tx")
    @Expose
    private Integer unconfirmedNTx;
    @SerializedName("final_n_tx")
    @Expose
    private Integer finalNTx;
    @SerializedName("txs")
    @Expose
    private List<Tx> txs = null;

    public List<Tx> getTxs() {
        return txs;
    }

    public static class Input {

        @SerializedName("prev_hash")
        @Expose
        private String prevHash;
        @SerializedName("output_index")
        @Expose
        private Integer outputIndex;
        @SerializedName("script")
        @Expose
        private String script;
        @SerializedName("output_value")
        @Expose
        private Integer outputValue;
        @SerializedName("sequence")
        @Expose
        private Integer sequence;
        @SerializedName("addresses")
        @Expose
        private List<String> addresses = null;
        @SerializedName("script_type")
        @Expose
        private String scriptType;

    }

    public static class Output {

        @SerializedName("value")
        @Expose
        private Integer value;
        @SerializedName("script")
        @Expose
        private String script;
        @SerializedName("addresses")
        @Expose
        private List<String> addresses = null;
        @SerializedName("script_type")
        @Expose
        private String scriptType;
        @SerializedName("spent_by")
        @Expose
        private String spentBy;
    }

    public static class Tx {

        @SerializedName("block_hash")
        @Expose
        private String blockHash;
        @SerializedName("block_height")
        @Expose
        private Integer blockHeight;
        @SerializedName("hash")
        @Expose
        private String hash;
        @SerializedName("addresses")
        @Expose
        private List<String> addresses = null;
        @SerializedName("total")
        @Expose
        private Integer total;
        @SerializedName("fees")
        @Expose
        private Integer fees;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("preference")
        @Expose
        private String preference;
        @SerializedName("relayed_by")
        @Expose
        private String relayedBy;
        @SerializedName("confirmed")
        @Expose
        private String confirmed;
        @SerializedName("received")
        @Expose
        private String received;
        @SerializedName("ver")
        @Expose
        private Integer ver;
        @SerializedName("lock_time")
        @Expose
        private Integer lockTime;
        @SerializedName("double_spend")
        @Expose
        private Boolean doubleSpend;
        @SerializedName("vin_sz")
        @Expose
        private Integer vinSz;
        @SerializedName("vout_sz")
        @Expose
        private Integer voutSz;
        @SerializedName("confirmations")
        @Expose
        private Integer confirmations;
        @SerializedName("confidence")
        @Expose
        private Integer confidence;
        @SerializedName("inputs")
        @Expose
        private List<Input> inputs = null;
        @SerializedName("outputs")
        @Expose
        private List<Output> outputs = null;

        public String getConfirmed() {
            return confirmed;
        }

        public Integer getTotal() {
            return total;
        }


    }

}

