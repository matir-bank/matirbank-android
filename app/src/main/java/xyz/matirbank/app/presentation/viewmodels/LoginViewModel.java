package xyz.matirbank.app.presentation.viewmodels;

import android.content.Intent;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import javax.inject.Inject;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.presentation.activities.common.DashboardActivity;
import xyz.matirbank.app.presentation.activities.accounts.LoginActivity;
import xyz.matirbank.app.services.interfaces.ISharedPreference;
import xyz.matirbank.app.utils.CommonConstants;
import xyz.matirbank.app.viewmodels.AccountsViewModel;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class LoginViewModel {

    @Inject
    ISharedPreference _sharedPreference;

    private final AccountsViewModel accountsViewModel;

    public LoginViewModel(LoginActivity activity) {
        // Init Dagger
        ThisApplication.getInstance().getComponents().inject(this);

        // Inti ViewModel
        accountsViewModel = new ViewModelProvider(activity).get(AccountsViewModel.class);

        // Init Observer
        observers(activity);
    }

    private void observers(LoginActivity activity) {

        accountsViewModel.getAccountsLogin().observe(activity, response -> {
            activity.hideLoading();
            if(response != null) {
                if(response.getStatus() == 200) {
                    if(response.getData() != null){
                        CommonConstants.AUTH_TOKEN = response.getData().getToken();
                        _sharedPreference.savePreference("_AUTH_TOKEN", CommonConstants.AUTH_TOKEN);
                        activity.startActivity(new Intent(activity, DashboardActivity.class).setFlags(FLAG_ACTIVITY_CLEAR_TOP|FLAG_ACTIVITY_SINGLE_TOP));
                        return;
                    }
                }
            }

            //TODO: Handle Server Error Responses

            // Login Failed
            Toast.makeText(ThisApplication.getContext(), "Login Failed", Toast.LENGTH_SHORT).show();
        });

    }

    public AccountsViewModel getAccountsViewModel() {
        return accountsViewModel;
    }
}
