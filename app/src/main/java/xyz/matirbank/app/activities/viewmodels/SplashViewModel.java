package xyz.matirbank.app.activities.viewmodels;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.activities.views.common.SplashActivity;
import xyz.matirbank.app.viewmodels.AccountsViewModel;

public class SplashViewModel {

    private AccountsViewModel accountsViewModel;

    public SplashViewModel(SplashActivity activity) {
        accountsViewModel = new ViewModelProvider(activity).get(AccountsViewModel.class);
    }

    private void observers(SplashActivity activity) {
        accountsViewModel.getAccount().observe(activity, response -> {
            if(response != null){
                Toast.makeText(ThisApplication.getContext(), "ACCOUNT: " + response.toString(), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(ThisApplication.getContext(), "ACCOUNT: NULL", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public AccountsViewModel getAccountsViewModel() {
        return accountsViewModel;
    }
}
