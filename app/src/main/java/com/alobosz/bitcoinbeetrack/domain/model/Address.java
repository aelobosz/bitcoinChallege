package com.alobosz.bitcoinbeetrack.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    private String _private;
    private String _public;
    private String address;
    private String wif;

    public Address(String _private, String _public, String address, String wif) {
        this._private = _private;
        this._public = _public;
        this.address = address;
        this.wif = wif;
    }

    public String get_private() {
        return _private;
    }

    public void set_private(String _private) {
        this._private = _private;
    }

    public String get_public() {
        return _public;
    }

    public void set_public(String _public) {
        this._public = _public;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWif() {
        return wif;
    }

    public void setWif(String wif) {
        this.wif = wif;
    }

}
