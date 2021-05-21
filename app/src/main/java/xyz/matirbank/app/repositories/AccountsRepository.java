package xyz.matirbank.app.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.interfaces.IAccountsAPI;
import xyz.matirbank.app.entities.api.accounts.Login;
import xyz.matirbank.app.entities.api.accounts.Register;

public class AccountsRepository {

    @Inject
    IAccountsAPI accountsAPI;

    private final MutableLiveData<ResponseBody> account = new MutableLiveData<>();
    private final MutableLiveData<ResponseBody> accountsRegister = new MutableLiveData<>();
    private final MutableLiveData<ResponseBody> accountsLogin = new MutableLiveData<>();
    private final MutableLiveData<ResponseBody> accountsLogout = new MutableLiveData<>();
    private final MutableLiveData<ResponseBody> accountsLogoutAll = new MutableLiveData<>();

    public AccountsRepository() {
        ThisApplication.getInstance().getComponents().inject(this);
    }

    /* Request */

    public void account() {
        accountsAPI.account(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                account.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                account.postValue(null);
            }
        });
    }

    public void accountsRegister(Register request) {
        accountsAPI.accountsRegister(request, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                accountsRegister.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                accountsRegister.postValue(null);
            }
        });
    }

    public void accountsLogin(Login request) {
        accountsAPI.accountsLogin(request, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                accountsLogin.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                accountsLogin.postValue(null);
            }
        });
    }

    public void accountsLogout() {
        accountsAPI.accountsLogout(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                accountsLogout.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                accountsLogout.postValue(null);
            }
        });
    }

    public void accountsLogoutAll() {
        accountsAPI.accountsLogoutAll(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                accountsLogoutAll.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                accountsLogoutAll.postValue(null);
            }
        });
    }

    /* Get */

    public LiveData<ResponseBody> getAccount() {
        return account;
    }

    public LiveData<ResponseBody> getAccountsRegister() {
        return accountsRegister;
    }

    public LiveData<ResponseBody> getAccountsLogin() {
        return accountsLogin;
    }

    public LiveData<ResponseBody> getAccountsLogout() {
        return accountsLogout;
    }

    public LiveData<ResponseBody> getAccountsLogoutAll() {
        return accountsLogoutAll;
    }

}
