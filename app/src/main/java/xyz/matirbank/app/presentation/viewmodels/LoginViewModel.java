package xyz.matirbank.app.presentation.viewmodels;

import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.presentation.activities.accounts.LoginActivity;
import xyz.matirbank.app.utils.CommonConstants;
import xyz.matirbank.app.viewmodels.AccountsViewModel;

public class LoginViewModel {

    private final AccountsViewModel accountsViewModel;

    public LoginViewModel(LoginActivity activity) {
        accountsViewModel = new ViewModelProvider(activity).get(AccountsViewModel.class);
        observers(activity);
    }

    private void observers(LoginActivity activity) {

        accountsViewModel.getAccount().observe(activity, response -> {
            if(response != null){
                Toast.makeText(ThisApplication.getContext(), "ACCOUNT: " + response.toString(), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(ThisApplication.getContext(), "ACCOUNT: NULL", Toast.LENGTH_SHORT).show();
            }
        });

        accountsViewModel.getAccountsLogin().observe(activity, response -> {
            activity.hideLoading();
            if(response != null) {
                if(response.getStatus() == 200) {
                    if(response.getData() != null){
                        CommonConstants.AUTH_TOKEN = response.getData().getToken();
                        Toast.makeText(ThisApplication.getContext(), "ACCOUNT: " + response.getData().getToken(), Toast.LENGTH_SHORT).show();
                    }
                }
                if(response.getStatus() == 400) {
                    Toast.makeText(ThisApplication.getContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public AccountsViewModel getAccountsViewModel() {
        return accountsViewModel;
    }
}
