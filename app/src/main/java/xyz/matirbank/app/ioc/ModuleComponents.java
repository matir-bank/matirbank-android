package xyz.matirbank.app.ioc;

import javax.inject.Singleton;

import dagger.Component;
import xyz.matirbank.app.api.managers.CardsAPI;
import xyz.matirbank.app.api.managers.CashAPI;
import xyz.matirbank.app.presentation.activities.accounts.RegisterActivity;
import xyz.matirbank.app.presentation.activities.common.SplashActivity;
import xyz.matirbank.app.presentation.activities.accounts.LoginActivity;
import xyz.matirbank.app.api.managers.AccountsAPI;
import xyz.matirbank.app.presentation.viewmodels.DashboardViewModel;
import xyz.matirbank.app.presentation.viewmodels.LoginViewModel;
import xyz.matirbank.app.presentation.viewmodels.RegisterViewModel;
import xyz.matirbank.app.presentation.viewmodels.SplashViewModel;
import xyz.matirbank.app.repositories.AccountsRepository;
import xyz.matirbank.app.repositories.CardsRepository;
import xyz.matirbank.app.repositories.CashRepository;
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
    void inject(CardsAPI cardsAPI);
    void inject(CashAPI cashAPI);

    // Repositories
    void inject(AccountsRepository accountsRepository);
    void inject(CardsRepository cardsRepository);
    void inject(CashRepository cashRepository);

    // Activities
    void inject(SplashActivity splashActivity);
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);

    // Activity ViewModels
    void inject(SplashViewModel splashViewModel);
    void inject(RegisterViewModel registerViewModel);
    void inject(LoginViewModel loginViewModel);
    void inject(DashboardViewModel dashboardViewModel);

}
