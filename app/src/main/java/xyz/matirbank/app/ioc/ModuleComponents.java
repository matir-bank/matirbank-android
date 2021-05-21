package xyz.matirbank.app.ioc;

import javax.inject.Singleton;

import dagger.Component;
import xyz.matirbank.app.presentation.activities.accounts.RegisterActivity;
import xyz.matirbank.app.presentation.activities.common.SplashActivity;
import xyz.matirbank.app.presentation.activities.accounts.LoginActivity;
import xyz.matirbank.app.api.managers.AccountsAPI;
import xyz.matirbank.app.repositories.AccountsRepository;
import xyz.matirbank.app.services.RetrofitService;
import xyz.matirbank.app.services.SharedPreference;

@Singleton
@Component(modules = { Modules.class})
public interface ModuleComponents {

    // Services
    void inject(SharedPreference sharedPreference);
    void inject(RetrofitService retrofitService);

    // API Managers
    void inject(AccountsAPI accountsAPI);

    // Repositories
    void inject(AccountsRepository accountsRepository);

    // Activities
    void inject(SplashActivity splashActivity);
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);

}
