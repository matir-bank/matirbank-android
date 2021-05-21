package xyz.matirbank.app.services.interfaces;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public interface IRetrofitService {
    Retrofit getClient();
}
