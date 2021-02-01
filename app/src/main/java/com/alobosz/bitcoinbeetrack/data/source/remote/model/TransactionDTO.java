package com.alobosz.bitcoinbeetrack.data.source.remote.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"unused", "FieldMayBeFinal", "RedundantSuppression"})
public class TransactionDTO {
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("total_received")
    @Expose
    private Double
            totalReceived;
    @SerializedName("total_sent")
    @Expose
    private Double
            totalSent;
    @SerializedName("balance")
    @Expose
    private Double
            balance;
    @SerializedName("unconfirmed_balance")
    @Expose
    private Double
            unconfirmedBalance;
    @SerializedName("final_balance")
    @Expose
    private Double
            finalBalance;
    @SerializedName("n_tx")
    @Expose
    private Double
            nTx;
    @SerializedName("unconfirmed_n_tx")
    @Expose
    private Double
            unconfirmedNTx;
    @SerializedName("final_n_tx")
    @Expose
    private Double
            finalNTx;
    @SerializedName("txs")
    @Expose
    private List<Tx> txs = null;

    public List<Tx> getTxs() {
        return txs;
    }

    @SuppressWarnings("FieldMayBeFinal")
    public static class Input {

        @SerializedName("prev_hash")
        @Expose
        private String prevHash;
        @SerializedName("output_index")
        @Expose
        private Double
                outputIndex;
        @SerializedName("script")
        @Expose
        private String script;
        @SerializedName("output_value")
        @Expose
        private Double
                outputValue;
        @SerializedName("sequence")
        @Expose
        private Double
                sequence;
        @SerializedName("addresses")
        @Expose
        private List<String> addresses = null;
        @SerializedName("script_type")
        @Expose
        private String scriptType;

    }

    @SuppressWarnings("FieldMayBeFinal")
    public static class Output {

        @SerializedName("value")
        @Expose
        private Double
                value;
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

        public String getScriptType() {
            return scriptType;
        }

        public void setScriptType(String scriptType) {
            this.scriptType = scriptType;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }
    }

    @SuppressWarnings("FieldMayBeFinal")
    public static class Tx {

        @SerializedName("block_hash")
        @Expose
        private String blockHash;
        @SerializedName("block_height")
        @Expose
        private Double
                blockHeight;
        @SerializedName("hash")
        @Expose
        private String hash;
        @SerializedName("addresses")
        @Expose
        private List<String> addresses = null;
        @SerializedName("total")
        @Expose
        private Double
                total;
        @SerializedName("fees")
        @Expose
        private Double
                fees;
        @SerializedName("size")
        @Expose
        private Double
                size;
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
        private Double
                ver;
        @SerializedName("lock_time")
        @Expose
        private Double
                lockTime;
        @SerializedName("double_spend")
        @Expose
        private Boolean doubleSpend;
        @SerializedName("vin_sz")
        @Expose
        private Double
                vinSz;
        @SerializedName("vout_sz")
        @Expose
        private Double
                voutSz;
        @SerializedName("confirmations")
        @Expose
        private Double
                confirmations;
        @SerializedName("confidence")
        @Expose
        private Double
                confidence;
        @SerializedName("inputs")
        @Expose
        private List<Input> inputs = null;

        @SerializedName("outputs")
        @Expose
        private List<Output> outputs = null;

        public String getConfirmed() {
            return confirmed;
        }

        public Double
        getTotal() {
            return total;
        }

        public List<Output> getOutputs() {
            return outputs;
        }

        public void setOutputs(List<Output> outputs) {
            this.outputs = outputs;
        }

    }

}

