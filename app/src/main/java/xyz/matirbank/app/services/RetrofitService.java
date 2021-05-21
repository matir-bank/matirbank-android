package xyz.matirbank.app.services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.matirbank.app.BuildConfig;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.utils.CommonInterceptor;
import xyz.matirbank.app.services.interfaces.IRetrofitService;
import xyz.matirbank.app.utils.CommonConstants;
import zerobranch.androidremotedebugger.logging.NetLoggingInterceptor;

public class RetrofitService implements IRetrofitService {

    private final Retrofit retrofit;

    public RetrofitService() {
        ThisApplication.getInstance().getComponents().inject(this);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(CommonConstants.API_BASE_URL)
                .client(okHttpClientBuilder())
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }

    private OkHttpClient okHttpClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new CommonInterceptor());

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new NetLoggingInterceptor());
        }

        return builder.build();
    }

    public Retrofit getClient() {
        return retrofit;
    }


}
