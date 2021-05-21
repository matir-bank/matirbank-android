package xyz.matirbank.app.presentation.viewmodels;

import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.presentation.activities.accounts.LoginActivity;
import xyz.matirbank.app.presentation.activities.accounts.RegisterActivity;
import xyz.matirbank.app.utils.CommonConstants;
import xyz.matirbank.app.viewmodels.AccountsViewModel;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class RegisterViewModel {

    private final AccountsViewModel accountsViewModel;

    public RegisterViewModel(RegisterActivity activity) {
        accountsViewModel = new ViewModelProvider(activity).get(AccountsViewModel.class);
        observers(activity);
    }

    private void observers(RegisterActivity activity) {

        accountsViewModel.getAccountsRegister().observe(activity, response -> {
            if(response != null) {
                //
            }else{
                //
            }
        });

    }

    public AccountsViewModel getAccountsViewModel() {
        return accountsViewModel;
    }
}
