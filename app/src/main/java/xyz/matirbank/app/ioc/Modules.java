package xyz.matirbank.app.ioc;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.matirbank.app.services.RetrofitService;
import xyz.matirbank.app.services.SharedPreference;
import xyz.matirbank.app.services.interfaces.IRetrofitService;
import xyz.matirbank.app.services.interfaces.ISharedPreference;

@Module
public class Modules {

    /* Services */

    @Singleton
    @Provides
    public IRetrofitService provideRetrofit() {
        return new RetrofitService();
    }

    @Singleton
    @Provides
    public ISharedPreference provideSharedPreference() {
        return new SharedPreference();
    }

}
