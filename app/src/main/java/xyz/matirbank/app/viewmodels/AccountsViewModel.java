package xyz.matirbank.app.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import okhttp3.ResponseBody;
import xyz.matirbank.app.entities.api.accounts.Login;
import xyz.matirbank.app.entities.api.accounts.Register;
import xyz.matirbank.app.repositories.AccountsRepository;

public class AccountsViewModel extends AndroidViewModel {

    private final AccountsRepository accountsRepository;
    private final LiveData<ResponseBody> account;
    private final LiveData<ResponseBody> accountsRegister;
    private final LiveData<ResponseBody> accountsLogin;
    private final LiveData<ResponseBody> accountsLogout;
    private final LiveData<ResponseBody> accountsLogoutAll;

    public AccountsViewModel(@NonNull Application application) {
        super(application);
        accountsRepository = new AccountsRepository();
        account = accountsRepository.getAccount();
        accountsRegister = accountsRepository.getAccountsRegister();
        accountsLogin = accountsRepository.getAccountsLogin();
        accountsLogout = accountsRepository.getAccountsLogout();
        accountsLogoutAll = accountsRepository.getAccountsLogoutAll();
    }

    /* Request */

    public void account() {
        accountsRepository.account();
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
