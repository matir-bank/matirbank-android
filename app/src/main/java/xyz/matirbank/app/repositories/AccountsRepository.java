package xyz.matirbank.app.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.accounts.responses.IdCardResponse;
import xyz.matirbank.app.api.entities.accounts.responses.PhotoResponse;
import xyz.matirbank.app.api.interfaces.managers.IAccountsAPI;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;

public class AccountsRepository {

    @Inject
    IAccountsAPI accountsAPI;

    private final MutableLiveData<ResponseContainer<AccountResponse>> account = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<AccountResponse>> accountDetails = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<RegisterResponse>> accountsRegister = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<LoginResponse>> accountsLogin = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<Object>> accountsLogout = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<Object>> accountsLogoutAll = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<PhotoResponse>> photo = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<PhotoResponse>> addPhoto = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<List<IdCardResponse>>> idCardList = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<IdCardResponse>> addIdCard = new MutableLiveData<>();


    public AccountsRepository() {
        Log.d("Repository", "AccountsRepository Init");
        ThisApplication.getInstance().getComponents().inject(this);
    }

    /* Request */

    public void account() {
        accountsAPI.account(new Callback<ResponseContainer<AccountResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<AccountResponse>> call, Response<ResponseContainer<AccountResponse>> response) {
                account.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<AccountResponse>> call, Throwable t) {
                account.postValue(null);
            }
        });
    }

    public void accountDetails(String request) {
        accountsAPI.accountDetails(request, new Callback<ResponseContainer<AccountResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<AccountResponse>> call, Response<ResponseContainer<AccountResponse>> response) {
                accountDetails.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<AccountResponse>> call, Throwable t) {
                accountDetails.postValue(null);
            }
        });
    }

    public void accountsRegister(RegisterRequest request) {
        accountsAPI.accountsRegister(request, new Callback<ResponseContainer<RegisterResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<RegisterResponse>> call, Response<ResponseContainer<RegisterResponse>> response) {
                accountsRegister.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<RegisterResponse>> call, Throwable t) {
                accountsRegister.postValue(null);
            }
        });
    }

    public void accountsLogin(LoginRequest request) {
        accountsAPI.accountsLogin(request, new Callback<ResponseContainer<LoginResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<LoginResponse>> call, Response<ResponseContainer<LoginResponse>> response) {
                accountsLogin.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<LoginResponse>> call, Throwable t) {
                accountsLogin.postValue(null);
            }
        });
    }

    public void accountsLogout() {
        accountsAPI.accountsLogout(new Callback<ResponseContainer<Object>>() {
            @Override
            public void onResponse(Call<ResponseContainer<Object>> call, Response<ResponseContainer<Object>> response) {
                accountsLogout.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<Object>> call, Throwable t) {
                accountsLogout.postValue(null);
            }
        });
    }

    public void accountsLogoutAll() {
        accountsAPI.accountsLogoutAll(new Callback<ResponseContainer<Object>>() {
            @Override
            public void onResponse(Call<ResponseContainer<Object>> call, Response<ResponseContainer<Object>> response) {
                accountsLogoutAll.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<Object>> call, Throwable t) {
                accountsLogoutAll.postValue(null);
            }
        });
    }

    public void photo() {
        accountsAPI.photo(new Callback<ResponseContainer<PhotoResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<PhotoResponse>> call, Response<ResponseContainer<PhotoResponse>> response) {
                photo.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<PhotoResponse>> call, Throwable t) {
                photo.postValue(null);
            }
        });
    }

    public void addPhoto(MultipartBody.Part file) {
        accountsAPI.addPhoto(file, new Callback<ResponseContainer<PhotoResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<PhotoResponse>> call, Response<ResponseContainer<PhotoResponse>> response) {
                addPhoto.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<PhotoResponse>> call, Throwable t) {
                addPhoto.postValue(null);
            }
        });
    }

    public void idCardList() {
        accountsAPI.idCardList(new Callback<ResponseContainer<List<IdCardResponse>>>() {
            @Override
            public void onResponse(Call<ResponseContainer<List<IdCardResponse>>> call, Response<ResponseContainer<List<IdCardResponse>>> response) {
                idCardList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<List<IdCardResponse>>> call, Throwable t) {
                idCardList.postValue(null);
            }
        });
    }

    public void addIdCard(MultipartBody.Part type, MultipartBody.Part file) {
        accountsAPI.addIdCard(type, file, new Callback<ResponseContainer<IdCardResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<IdCardResponse>> call, Response<ResponseContainer<IdCardResponse>> response) {
                addIdCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<IdCardResponse>> call, Throwable t) {
                addIdCard.postValue(null);
            }
        });
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

    public MutableLiveData<ResponseContainer<PhotoResponse>> getPhoto() {
        return photo;
    }

    public MutableLiveData<ResponseContainer<PhotoResponse>> getAddPhoto() {
        return addPhoto;
    }

    public MutableLiveData<ResponseContainer<List<IdCardResponse>>> getIdCardList() {
        return idCardList;
    }

    public MutableLiveData<ResponseContainer<IdCardResponse>> getAddIdCard() {
        return addIdCard;
    }
}
