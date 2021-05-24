package xyz.matirbank.app.presentation.viewmodels;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.presentation.activities.common.SplashActivity;
import xyz.matirbank.app.services.interfaces.ISharedPreference;
import xyz.matirbank.app.utils.CommonConstants;
import xyz.matirbank.app.viewmodels.AccountsViewModel;

public class SplashViewModel {

    @Inject
    ISharedPreference _sharedPreference;

    private final AccountsViewModel accountsViewModel;

    public SplashViewModel(SplashActivity activity) {
        // Init Dagger
        ThisApplication.getInstance().getComponents().inject(this);

        // Init ViewModel
        accountsViewModel = new ViewModelProvider(activity).get(AccountsViewModel.class);

        // Set Auth Token
        CommonConstants.AUTH_TOKEN = _sharedPreference.loadPreference("_AUTH_TOKEN", "");

        // Init Observer
        observers(activity);
    }

    private void observers(SplashActivity activity) {
        accountsViewModel.getAccount().observe(activity, response -> {
            if(response != null){
                if(response.getData() != null) {
                    if(response.getData().getId() != null) {
                        activity.isLoggedIn = true;
                    }
                }
            }
        });
    }

    public AccountsViewModel getAccountsViewModel() {
        return accountsViewModel;
    }
}
