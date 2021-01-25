package com.alobosz.bitcoinbeetrack.data.util;

public class ApiConstants {

    public static final String API_VERSION = "v1";
    public static final String API_COIN = "btc";
    public static final String API_CHAIN = "test3";
    public static final String ADDRESS = "address";
    private static final String API_PATH = API_VERSION + "/" + API_COIN + "/" + API_CHAIN + "/";
    public static final String PATH_GENERATE_ADDRESS = API_PATH + "addrs";
    public static final String PATH_ADDRESS_BALANCE = API_PATH + "addrs/{" + ADDRESS + "}}/balance";
    public static final String PATH_ADDRESS_FULL_BALANCE = API_PATH + "addrs/{" + ADDRESS + "}/full";

}
