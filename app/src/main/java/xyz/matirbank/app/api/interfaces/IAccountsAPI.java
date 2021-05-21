package xyz.matirbank.app.api.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.entities.api.accounts.Login;
import xyz.matirbank.app.entities.api.accounts.Register;

public interface IAccountsAPI {

    void account(Callback<ResponseBody> callback);
    void accountsRegister(Register request, Callback<ResponseBody> callback);
    void accountsLogin(Login request, Callback<ResponseBody> callback);
    void accountsLogout(Callback<ResponseBody> callback);
    void accountsLogoutAll(Callback<ResponseBody> callback);

}
