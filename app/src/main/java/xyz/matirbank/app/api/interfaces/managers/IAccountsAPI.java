package xyz.matirbank.app.api.interfaces.managers;

import retrofit2.Callback;
import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.Register;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;

public interface IAccountsAPI {

    void account(Callback<ResponseContainer<AccountResponse>> callback);
    void accountDetails(String request, Callback<ResponseContainer<AccountResponse>> callback);
    void accountsRegister(Register request, Callback<ResponseContainer<RegisterResponse>> callback);
    void accountsLogin(Login request, Callback<ResponseContainer<LoginResponse>> callback);
    void accountsLogout(Callback<ResponseContainer<Object>> callback);
    void accountsLogoutAll(Callback<ResponseContainer<Object>> callback);

}
