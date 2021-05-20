package xyz.matirbank.app.api;

import retrofit2.Retrofit;

public class RetrofitClient {

    private static RetrofitClient retrofitClient;

    public RetrofitClient init() {
        if(retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    RetrofitClient() {

    }



}
