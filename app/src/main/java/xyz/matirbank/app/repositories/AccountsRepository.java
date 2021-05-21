package xyz.matirbank.app.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.interfaces.managers.IAccountsAPI;
import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.Register;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;

public class AccountsRepository {

    @Inject
    IAccountsAPI accountsAPI;

    private final MutableLiveData<ResponseContainer<AccountResponse>> account = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<AccountResponse>> accountDetails = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<RegisterResponse>> accountsRegister = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<LoginResponse>> accountsLogin = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<Object>> accountsLogout = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<Object>> accountsLogoutAll = new MutableLiveData<>();

    public AccountsRepository() {
        Log.d("Repository", "AccountsRepository Init");
        ThisApplication.getInstance().getComponents().inject(this);
    }

    /* Request */

    public void account() {
        accountsAPI.account(new Callback<ResponseContainer<AccountResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<AccountResponse>> call, Response<ResponseContainer<AccountResponse>> response) {
                account.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<AccountResponse>> call, Throwable t) {
                account.postValue(null);
            }
        });
    }

    public void accountDetails(String request) {
        accountsAPI.accountDetails(request, new Callback<ResponseContainer<AccountResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<AccountResponse>> call, Response<ResponseContainer<AccountResponse>> response) {
                accountDetails.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<AccountResponse>> call, Throwable t) {
                accountDetails.postValue(null);
            }
        });
    }

    public void accountsRegister(Register request) {
        accountsAPI.accountsRegister(request, new Callback<ResponseContainer<RegisterResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<RegisterResponse>> call, Response<ResponseContainer<RegisterResponse>> response) {
                accountsRegister.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<RegisterResponse>> call, Throwable t) {
                accountsRegister.postValue(null);
            }
        });
    }

    public void accountsLogin(Login request) {
        accountsAPI.accountsLogin(request, new Callback<ResponseContainer<LoginResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<LoginResponse>> call, Response<ResponseContainer<LoginResponse>> response) {
                accountsLogin.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<LoginResponse>> call, Throwable t) {
                accountsLogin.postValue(null);
            }
        });
    }

    public void accountsLogout() {
        accountsAPI.accountsLogout(new Callback<ResponseContainer<Object>>() {
            @Override
            public void onResponse(Call<ResponseContainer<Object>> call, Response<ResponseContainer<Object>> response) {
                accountsLogout.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<Object>> call, Throwable t) {
                accountsLogout.postValue(null);
            }
        });
    }

    public void accountsLogoutAll() {
        accountsAPI.accountsLogoutAll(new Callback<ResponseContainer<Object>>() {
            @Override
            public void onResponse(Call<ResponseContainer<Object>> call, Response<ResponseContainer<Object>> response) {
                accountsLogoutAll.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<Object>> call, Throwable t) {
                accountsLogoutAll.postValue(null);
            }
        });
    }

    /* Get */

    public LiveData<ResponseContainer<AccountResponse>> getAccount() {
        return account;
    }

    public LiveData<ResponseContainer<AccountResponse>> getAccountDetails() {
        return accountDetails;
    }

    public LiveData<ResponseContainer<RegisterResponse>> getAccountsRegister() {
        return accountsRegister;
    }

    public LiveData<ResponseContainer<LoginResponse>> getAccountsLogin() {
        return accountsLogin;
    }

    public LiveData<ResponseContainer<Object>> getAccountsLogout() {
        return accountsLogout;
    }

    public LiveData<ResponseContainer<Object>> getAccountsLogoutAll() {
        return accountsLogoutAll;
    }

}
