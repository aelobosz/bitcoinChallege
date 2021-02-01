package com.alobosz.bitcoinbeetrack.data.source.remote;

import com.alobosz.bitcoinbeetrack.data.source.remote.model.AddressDTO;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.BalanceDTO;
import com.alobosz.bitcoinbeetrack.data.source.remote.model.TransactionDTO;
import com.alobosz.bitcoinbeetrack.data.util.ApiConstants;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.alobosz.bitcoinbeetrack.data.util.ApiConstants.ADDRESS;
import static com.alobosz.bitcoinbeetrack.data.util.ApiConstants.PATH_ADDRESS_BALANCE;
import static com.alobosz.bitcoinbeetrack.data.util.ApiConstants.PATH_ADDRESS_TRANSACTIONS;
import static com.alobosz.bitcoinbeetrack.data.util.ApiConstants.PATH_GENERATE_ADDRESS;

public interface BlockCypherAddressApi {
    @POST(PATH_GENERATE_ADDRESS)
    Single<AddressDTO> generateAddress();

    @GET(PATH_ADDRESS_BALANCE)
    Single<BalanceDTO> getAddressBalance(@Path(ApiConstants.ADDRESS) String address);

    @GET(PATH_ADDRESS_TRANSACTIONS)
    Single<TransactionDTO> getAddressTransactions(@Path(ADDRESS) String address);

}
