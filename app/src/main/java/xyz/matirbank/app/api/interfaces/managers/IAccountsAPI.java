package xyz.matirbank.app.api.interfaces.managers;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Callback;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.IdCardResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;
import xyz.matirbank.app.api.entities.accounts.responses.PhotoResponse;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;

public interface IAccountsAPI {

    void account(Callback<ResponseContainer<AccountResponse>> callback);
    void accountDetails(String request, Callback<ResponseContainer<AccountResponse>> callback);
    void accountsRegister(RegisterRequest request, Callback<ResponseContainer<RegisterResponse>> callback);
    void accountsLogin(LoginRequest request, Callback<ResponseContainer<LoginResponse>> callback);
    void accountsLogout(Callback<ResponseContainer<Object>> callback);
    void accountsLogoutAll(Callback<ResponseContainer<Object>> callback);
    void photo(Callback<ResponseContainer<PhotoResponse>> callback);
    void addPhoto(MultipartBody.Part file, Callback<ResponseContainer<PhotoResponse>> callback);
    void idCardList(Callback<ResponseContainer<List<IdCardResponse>>> callback);
    void addIdCard(MultipartBody.Part type, MultipartBody.Part file, Callback<ResponseContainer<IdCardResponse>> callback);

}
