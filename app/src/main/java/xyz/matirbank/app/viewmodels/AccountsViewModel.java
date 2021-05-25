package xyz.matirbank.app.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import okhttp3.MultipartBody;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.IdCardResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;
import xyz.matirbank.app.api.entities.accounts.responses.PhotoResponse;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.repositories.AccountsRepository;

public class AccountsViewModel extends AndroidViewModel {

    private final AccountsRepository accountsRepository = new AccountsRepository();
    private final LiveData<ResponseContainer<AccountResponse>> accountSelf = accountsRepository.getAccountSelf();
    private final LiveData<ResponseContainer<AccountResponse>> accountDetails = accountsRepository.getAccountDetails();
    private final LiveData<ResponseContainer<RegisterResponse>> accountsRegister = accountsRepository.getAccountsRegister();
    private final LiveData<ResponseContainer<LoginResponse>> accountsLogin = accountsRepository.getAccountsLogin();
    private final LiveData<ResponseContainer<Object>> accountsLogout = accountsRepository.getAccountsLogout();
    private final LiveData<ResponseContainer<Object>> accountsLogoutAll = accountsRepository.getAccountsLogoutAll();
    private final LiveData<ResponseContainer<PhotoResponse>> photo = accountsRepository.getPhoto();
    private final LiveData<ResponseContainer<PhotoResponse>> addPhoto = accountsRepository.getAddPhoto();
    private final LiveData<ResponseContainer<List<IdCardResponse>>> idCardList = accountsRepository.getIdCardList();
    private final LiveData<ResponseContainer<IdCardResponse>> addIdCard = accountsRepository.getAddIdCard();

    public AccountsViewModel(@NonNull Application application) {
        super(application);
    }

    /* Request */

    public void accountSelf() {
        accountsRepository.accountSelf();
    }

    public void accountDetails(String request) {
        accountsRepository.accountDetails(request);
    }

    public void accountsRegister(RegisterRequest request) {
        accountsRepository.accountsRegister(request);
    }

    public void accountsLogin(LoginRequest request) {
        accountsRepository.accountsLogin(request);
    }

    public void accountsLogout() {
        accountsRepository.accountsLogout();
    }

    public void accountsLogoutAll() {
        accountsRepository.accountsLogoutAll();
    }

    public void photo() {
        accountsRepository.photo();
    }

    public void addPhoto(MultipartBody.Part file) {
        accountsRepository.addPhoto(file);
    }

    public void idCardList() {
        accountsRepository.idCardList();
    }

    public void addIdCard(MultipartBody.Part type, MultipartBody.Part file) {
        accountsRepository.addIdCard(type, file);
    }

    /* Get */

    public LiveData<ResponseContainer<AccountResponse>> getAccountSelf() {
        return accountSelf;
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

    public LiveData<ResponseContainer<PhotoResponse>> getPhoto() {
        return photo;
    }

    public LiveData<ResponseContainer<PhotoResponse>> getAddPhoto() {
        return addPhoto;
    }

    public LiveData<ResponseContainer<List<IdCardResponse>>> getIdCardList() {
        return idCardList;
    }

    public LiveData<ResponseContainer<IdCardResponse>> getAddIdCard() {
        return addIdCard;
    }
}
