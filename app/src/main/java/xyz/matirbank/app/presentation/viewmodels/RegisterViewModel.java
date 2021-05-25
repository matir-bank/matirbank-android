package xyz.matirbank.app.presentation.viewmodels;

import android.content.Intent;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import javax.inject.Inject;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.presentation.activities.common.DashboardActivity;
import xyz.matirbank.app.presentation.activities.accounts.RegisterActivity;
import xyz.matirbank.app.services.interfaces.ISharedPreference;
import xyz.matirbank.app.utils.CommonConstants;
import xyz.matirbank.app.utils.CommonUtils;
import xyz.matirbank.app.viewmodels.AccountsViewModel;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class RegisterViewModel {

    @Inject
    ISharedPreference _sharedPreference;

    private final AccountsViewModel accountsViewModel;

    public RegisterViewModel(RegisterActivity activity) {
        // Init Dagger
        ThisApplication.getInstance().getComponents().inject(this);

        // Init ViewModel
        accountsViewModel = new ViewModelProvider(activity).get(AccountsViewModel.class);

        // Init Observer
        observers(activity);
    }

    private void observers(RegisterActivity activity) {
        accountsViewModel.getAccountsRegister().observe(activity, response -> {
            activity.hideLoading();

            if(response != null){
                if(response.getData() != null) {
                    if(response.getData().getToken() != null) {
                        CommonConstants.AUTH_TOKEN = response.getData().getToken();
                        CommonConstants.AUTH_EXPIRES = CommonUtils.getCurrentTime() + 3600;
                        _sharedPreference.savePreference("_AUTH_TOKEN", CommonConstants.AUTH_TOKEN);
                        _sharedPreference.savePreference("_AUTH_EXPIRES", CommonConstants.AUTH_EXPIRES);
                        activity.startActivity(new Intent(activity, DashboardActivity.class).setFlags(FLAG_ACTIVITY_CLEAR_TOP|FLAG_ACTIVITY_SINGLE_TOP));
                        return;
                    }
                }
            }

            //TODO: Handle Server Error Responses

            // Login Failed
            Toast.makeText(ThisApplication.getContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
        });
    }

    public AccountsViewModel getAccountsViewModel() {
        return accountsViewModel;
    }
}
