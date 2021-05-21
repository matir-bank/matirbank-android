package xyz.matirbank.app.api.managers;

import javax.inject.Inject;

import retrofit2.Callback;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.interfaces.apis.IAccounts;
import xyz.matirbank.app.api.interfaces.managers.IAccountsAPI;
import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.Register;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
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
    public void account(Callback<ResponseContainer<AccountResponse>> callback) {
        accounts.account().enqueue(callback);
    }

    @Override
    public void accountDetails(String request, Callback<ResponseContainer<AccountResponse>> callback) {
        accounts.accountDetails(request).enqueue(callback);
    }

    @Override
    public void accountsRegister(Register request, Callback<ResponseContainer<RegisterResponse>> callback) {
        accounts.accountsRegister(request).enqueue(callback);
    }

    @Override
    public void accountsLogin(Login request, Callback<ResponseContainer<LoginResponse>> callback) {
        accounts.accountsLogin(request).enqueue(callback);
    }

    @Override
    public void accountsLogout(Callback<ResponseContainer<Object>> callback) {
        accounts.accountsLogout().enqueue(callback);
    }

    @Override
    public void accountsLogoutAll(Callback<ResponseContainer<Object>> callback) {
        accounts.accountsLogoutAll().enqueue(callback);
    }

}
