package com.alobosz.bitcoinbeetrack.data.source.remote;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiBitcoin {
    @GET("orgs/Google/repos")
    Single<List<Object>> getRepositories();

    @GET("repos/{owner}/{name}")
    Single<Object> getRepo(@Path("owner") String owner, @Path("name") String name);
}
