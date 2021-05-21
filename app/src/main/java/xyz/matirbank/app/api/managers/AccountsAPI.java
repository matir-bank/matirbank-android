package xyz.matirbank.app.api.managers;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.interfaces.IAccounts;
import xyz.matirbank.app.api.interfaces.IAccountsAPI;
import xyz.matirbank.app.entities.api.accounts.Login;
import xyz.matirbank.app.entities.api.accounts.Register;
import xyz.matirbank.app.services.interfaces.IRetrofitService;

public class AccountsAPI implements IAccountsAPI {

    @Inject
    IRetrofitService _retrofitService;

    IAccounts accounts;

    public AccountsAPI() {
        ThisApplication.getInstance().getComponents().inject(this);
        accounts = _retrofitService.getClient().create(IAccounts.class);
    }

    @Override
    public void account(Callback<ResponseBody> callback) {
        accounts.account().enqueue(callback);
    }

    @Override
    public void accountsRegister(Register request, Callback<ResponseBody> callback) {
        accounts.accountsRegister(request).enqueue(callback);
    }

    @Override
    public void accountsLogin(Login request, Callback<ResponseBody> callback) {
        accounts.accountsLogin(request).enqueue(callback);
    }

    @Override
    public void accountsLogout(Callback<ResponseBody> callback) {
        accounts.accountsLogout().enqueue(callback);
    }

    @Override
    public void accountsLogoutAll(Callback<ResponseBody> callback) {
        accounts.accountsLogoutAll().enqueue(callback);
    }

}
