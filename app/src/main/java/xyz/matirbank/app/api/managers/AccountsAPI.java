package xyz.matirbank.app.api.managers;

import java.util.List;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import retrofit2.Callback;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.accounts.responses.IdCardResponse;
import xyz.matirbank.app.api.entities.accounts.responses.PhotoResponse;
import xyz.matirbank.app.api.interfaces.apis.IAccounts;
import xyz.matirbank.app.api.interfaces.managers.IAccountsAPI;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.services.interfaces.IRetrofitService;

public class AccountsAPI implements IAccountsAPI {

    @Inject
    IRetrofitService _retrofitService;
    private final IAccounts accounts;

    public AccountsAPI() {
        ThisApplication.getInstance().getComponents().inject(this);
        accounts = _retrofitService.getClient().create(IAccounts.class);
    }

    @Override
    public void account(Callback<ResponseContainer<AccountResponse>> callback) {
        accounts.accountsList().enqueue(callback);
    }

    @Override
    public void accountDetails(String request, Callback<ResponseContainer<AccountResponse>> callback) {
        accounts.accountsDetails(request).enqueue(callback);
    }

    @Override
    public void accountsRegister(RegisterRequest request, Callback<ResponseContainer<RegisterResponse>> callback) {
        accounts.accountsRegister(request).enqueue(callback);
    }

    @Override
    public void accountsLogin(LoginRequest request, Callback<ResponseContainer<LoginResponse>> callback) {
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

    @Override
    public void photo(Callback<ResponseContainer<PhotoResponse>> callback) {
        accounts.photo().enqueue(callback);
    }

    @Override
    public void addPhoto(MultipartBody.Part file, Callback<ResponseContainer<PhotoResponse>> callback) {
        accounts.addPhoto(file).enqueue(callback);
    }

    @Override
    public void idCardList(Callback<ResponseContainer<List<IdCardResponse>>> callback) {
        accounts.idCardList().enqueue(callback);
    }

    @Override
    public void addIdCard(MultipartBody.Part type, MultipartBody.Part file, Callback<ResponseContainer<IdCardResponse>> callback) {
        accounts.addIdCard(type, file).enqueue(callback);
    }

}
