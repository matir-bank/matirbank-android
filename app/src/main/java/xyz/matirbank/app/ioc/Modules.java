package xyz.matirbank.app.ioc;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.matirbank.app.api.interfaces.IAccountsAPI;
import xyz.matirbank.app.api.managers.AccountsAPI;
import xyz.matirbank.app.services.RetrofitService;
import xyz.matirbank.app.services.SharedPreference;
import xyz.matirbank.app.services.interfaces.IAccountServices;
import xyz.matirbank.app.services.AccountServices;
import xyz.matirbank.app.services.interfaces.IRetrofitService;
import xyz.matirbank.app.services.interfaces.ISharedPreference;

@Module
public class Modules {

    @Singleton
    @Provides
    public IRetrofitService provideRetrofit() {
        return new RetrofitService();
    }

    @Singleton
    @Provides
    public IAccountServices provideAccount() {
        return new AccountServices();
    }

    @Singleton
    @Provides
    public ISharedPreference provideSharedPreference() {
        return new SharedPreference();
    }

    /* API */

    @Singleton
    @Provides
    public IAccountsAPI provideAccountsAPI() {
        return new AccountsAPI();
    }

}
