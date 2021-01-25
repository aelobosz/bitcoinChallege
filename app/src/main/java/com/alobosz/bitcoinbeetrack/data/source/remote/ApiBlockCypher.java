package com.alobosz.bitcoinbeetrack.data.source.remote;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.Address;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Balance;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.Transaction;
import com.alobosz.bitcoinbeetrack.data.util.ApiConstants;

import io.reactivex.Single;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.alobosz.bitcoinbeetrack.data.util.ApiConstants.ADDRESS;
import static com.alobosz.bitcoinbeetrack.data.util.ApiConstants.PATH_ADDRESS_BALANCE;
import static com.alobosz.bitcoinbeetrack.data.util.ApiConstants.PATH_ADDRESS_FULL_BALANCE;
import static com.alobosz.bitcoinbeetrack.data.util.ApiConstants.PATH_GENERATE_ADDRESS;

public interface ApiBlockCypher {
    @POST(PATH_GENERATE_ADDRESS)
    public Single<Address> generateAddress();

    @GET(PATH_ADDRESS_BALANCE)
    public Single<Balance> getAddressBalance(@Path(ApiConstants.ADDRESS) String address);

    @GET(PATH_ADDRESS_FULL_BALANCE)
    public Single<Transaction> getAddressTransactions(@Path(ADDRESS) String address);

}
