package xyz.matirbank.app.ioc;

import javax.inject.Singleton;

import dagger.Component;
import xyz.matirbank.app.activities.views.common.SplashActivity;
import xyz.matirbank.app.activities.views.accounts.LoginActivity;
import xyz.matirbank.app.api.managers.AccountsAPI;
import xyz.matirbank.app.repositories.AccountsRepository;
import xyz.matirbank.app.services.AccountServices;
import xyz.matirbank.app.services.RetrofitService;
import xyz.matirbank.app.services.SharedPreference;

@Singleton
@Component(modules = { Modules.class})
public interface ModuleComponents {

    // Services
    void inject(AccountServices accountServices);
    void inject(SharedPreference sharedPreference);
    void inject(RetrofitService retrofitService);

    // API Managers
    void inject(AccountsAPI accountsAPI);

    // Repositories
    void inject(AccountsRepository accountsRepository);

    // Activities
    void inject(SplashActivity splashActivity);
    void inject(LoginActivity loginActivity);

}
