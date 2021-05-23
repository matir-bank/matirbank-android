package xyz.matirbank.app.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.Register;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.repositories.AccountsRepository;

public class AccountsViewModel extends AndroidViewModel {

    private final AccountsRepository accountsRepository = new AccountsRepository();
    private final LiveData<ResponseContainer<AccountResponse>> account = accountsRepository.getAccount();
    private final LiveData<ResponseContainer<AccountResponse>> accountDetails = accountsRepository.getAccountDetails();
    private final LiveData<ResponseContainer<RegisterResponse>> accountsRegister = accountsRepository.getAccountsRegister();
    private final LiveData<ResponseContainer<LoginResponse>> accountsLogin = accountsRepository.getAccountsLogin();
    private final LiveData<ResponseContainer<Object>> accountsLogout = accountsRepository.getAccountsLogout();
    private final LiveData<ResponseContainer<Object>> accountsLogoutAll = accountsRepository.getAccountsLogoutAll();

    public AccountsViewModel(@NonNull Application application) {
        super(application);
    }

    /* Request */

    public void account() {
        accountsRepository.account();
    }

    public void accountDetails(String request) {
        accountsRepository.accountDetails(request);
    }

    public void accountsRegister(Register request) {
        accountsRepository.accountsRegister(request);
    }

    public void accountsLogin(Login request) {
        accountsRepository.accountsLogin(request);
    }

    public void accountsLogout() {
        accountsRepository.accountsLogout();
    }

    public void accountsLogoutAll() {
        accountsRepository.accountsLogoutAll();
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
