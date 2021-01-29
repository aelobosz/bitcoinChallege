package com.alobosz.bitcoinbeetrack.data.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressDTO {

    @SerializedName("private")
    @Expose
    private String _private;
    @SerializedName("public")
    @Expose
    private String _public;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("wif")
    @Expose
    private String wif;

    public String getPrivate() {
        return _private;
    }

    public void setPrivate(String _private) {
        this._private = _private;
    }

    public String getPublic() {
        return _public;
    }

    public void setPublic(String _public) {
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