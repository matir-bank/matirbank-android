package xyz.matirbank.app.presentation.viewmodels;

import androidx.lifecycle.ViewModelProvider;

import xyz.matirbank.app.presentation.activities.accounts.RegisterActivity;
import xyz.matirbank.app.viewmodels.AccountsViewModel;

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
