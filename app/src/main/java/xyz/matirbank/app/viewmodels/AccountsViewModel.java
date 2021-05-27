package xyz.matirbank.app.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import okhttp3.MultipartBody;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;
import xyz.matirbank.app.api.interfaces.Types;
import xyz.matirbank.app.repositories.AccountsRepository;

public class AccountsViewModel extends AndroidViewModel {

    private final AccountsRepository accountsRepository = new AccountsRepository();
    private final LiveData<Types.AccountResponse> accountSelf = accountsRepository.getAccountSelf();
    private final LiveData<Types.AccountResponse> accountDetails = accountsRepository.getAccountDetails();
    private final LiveData<Types.RegisterResponse> accountsRegister = accountsRepository.getAccountsRegister();
    private final LiveData<Types.LoginResponse> accountsLogin = accountsRepository.getAccountsLogin();
    private final LiveData<Types.ObjectResponse> accountsLogout = accountsRepository.getAccountsLogout();
    private final LiveData<Types.ObjectResponse> accountsLogoutAll = accountsRepository.getAccountsLogoutAll();
    private final LiveData<Types.PhotoResponse> photo = accountsRepository.getPhoto();
    private final LiveData<Types.PhotoResponse> addPhoto = accountsRepository.getAddPhoto();
    private final LiveData<Types.IdCardListResponse> idCardList = accountsRepository.getIdCardList();
    private final LiveData<Types.IdCardResponse> addIdCard = accountsRepository.getAddIdCard();

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

    public LiveData<Types.AccountResponse> getAccountSelf() {
        return accountSelf;
    }

    public LiveData<Types.AccountResponse> getAccountDetails() {
        return accountDetails;
    }

    public LiveData<Types.RegisterResponse> getAccountsRegister() {
        return accountsRegister;
    }

    public LiveData<Types.LoginResponse> getAccountsLogin() {
        return accountsLogin;
    }

    public LiveData<Types.ObjectResponse> getAccountsLogout() {
        return accountsLogout;
    }

    public LiveData<Types.ObjectResponse> getAccountsLogoutAll() {
        return accountsLogoutAll;
    }

    public LiveData<Types.PhotoResponse> getPhoto() {
        return photo;
    }

    public LiveData<Types.PhotoResponse> getAddPhoto() {
        return addPhoto;
    }

    public LiveData<Types.IdCardListResponse> getIdCardList() {
        return idCardList;
    }

    public LiveData<Types.IdCardResponse> getAddIdCard() {
        return addIdCard;
    }
}
