package xyz.matirbank.app.repositories;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.interfaces.Types;
import xyz.matirbank.app.api.interfaces.IAccounts;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;
import xyz.matirbank.app.services.interfaces.IRetrofitService;

public class AccountsRepository {

    @Inject
    IRetrofitService _retrofitService;
    private final IAccounts accountsAPI;

    private final MutableLiveData<Types.AccountResponse> accountSelf = new MutableLiveData<>();
    private final MutableLiveData<Types.AccountResponse> accountDetails = new MutableLiveData<>();
    private final MutableLiveData<Types.RegisterResponse> accountsRegister = new MutableLiveData<>();
    private final MutableLiveData<Types.LoginResponse> accountsLogin = new MutableLiveData<>();
    private final MutableLiveData<Types.ObjectResponse> accountsLogout = new MutableLiveData<>();
    private final MutableLiveData<Types.ObjectResponse> accountsLogoutAll = new MutableLiveData<>();
    private final MutableLiveData<Types.PhotoResponse> photo = new MutableLiveData<>();
    private final MutableLiveData<Types.PhotoResponse> addPhoto = new MutableLiveData<>();
    private final MutableLiveData<Types.IdCardListResponse> idCardList = new MutableLiveData<>();
    private final MutableLiveData<Types.IdCardResponse> addIdCard = new MutableLiveData<>();

    public AccountsRepository() {
        ThisApplication.getInstance().getComponents().inject(this);
        accountsAPI = _retrofitService.getClient().create(IAccounts.class);
    }

    /* Request */

    public void accountSelf() {
        accountsAPI.accountSelf().enqueue(new Callback<Types.AccountResponse>() {
            @Override
            public void onResponse(Call<Types.AccountResponse> call, Response<Types.AccountResponse> response) {
                accountSelf.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.AccountResponse> call, Throwable t) {
                accountSelf.postValue(null);
            }
        });
    }

    public void accountDetails(String request) {
        accountsAPI.accountsDetails(request).enqueue(new Callback<Types.AccountResponse>() {
            @Override
            public void onResponse(Call<Types.AccountResponse> call, Response<Types.AccountResponse> response) {
                accountDetails.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.AccountResponse> call, Throwable t) {
                accountDetails.postValue(null);
            }
        });
    }

    public void accountsRegister(RegisterRequest request) {
        accountsAPI.accountsRegister(request).enqueue(new Callback<Types.RegisterResponse>() {
            @Override
            public void onResponse(Call<Types.RegisterResponse> call, Response<Types.RegisterResponse> response) {
                accountsRegister.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.RegisterResponse> call, Throwable t) {
                accountsRegister.postValue(null);
            }
        });
    }

    public void accountsLogin(LoginRequest request) {
        accountsAPI.accountsLogin(request).enqueue(new Callback<Types.LoginResponse>() {
            @Override
            public void onResponse(Call<Types.LoginResponse> call, Response<Types.LoginResponse> response) {
                accountsLogin.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.LoginResponse> call, Throwable t) {
                accountsLogin.postValue(null);
            }
        });
    }

    public void accountsLogout() {
        accountsAPI.accountsLogout().enqueue(new Callback<Types.ObjectResponse>() {
            @Override
            public void onResponse(Call<Types.ObjectResponse> call, Response<Types.ObjectResponse> response) {
                accountsLogout.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.ObjectResponse> call, Throwable t) {
                accountsLogout.postValue(null);
            }
        });
    }

    public void accountsLogoutAll() {
        accountsAPI.accountsLogoutAll().enqueue(new Callback<Types.ObjectResponse>() {
            @Override
            public void onResponse(Call<Types.ObjectResponse> call, Response<Types.ObjectResponse> response) {
                accountsLogoutAll.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.ObjectResponse> call, Throwable t) {
                accountsLogoutAll.postValue(null);
            }
        });
    }

    public void photo() {
        accountsAPI.photo().enqueue(new Callback<Types.PhotoResponse>() {
            @Override
            public void onResponse(Call<Types.PhotoResponse> call, Response<Types.PhotoResponse> response) {
                photo.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.PhotoResponse> call, Throwable t) {
                photo.postValue(null);
            }
        });
    }

    public void addPhoto(MultipartBody.Part file) {
        accountsAPI.addPhoto(file).enqueue(new Callback<Types.PhotoResponse>() {
            @Override
            public void onResponse(Call<Types.PhotoResponse> call, Response<Types.PhotoResponse> response) {
                addPhoto.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.PhotoResponse> call, Throwable t) {
                addPhoto.postValue(null);
            }
        });
    }

    public void idCardList() {
        accountsAPI.idCardList().enqueue(new Callback<Types.IdCardListResponse>() {
            @Override
            public void onResponse(Call<Types.IdCardListResponse> call, Response<Types.IdCardListResponse> response) {
                idCardList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.IdCardListResponse> call, Throwable t) {
                idCardList.postValue(null);
            }
        });
    }

    public void addIdCard(MultipartBody.Part type, MultipartBody.Part file) {
        accountsAPI.addIdCard(type, file).enqueue(new Callback<Types.IdCardResponse>() {
            @Override
            public void onResponse(Call<Types.IdCardResponse> call, Response<Types.IdCardResponse> response) {
                addIdCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.IdCardResponse> call, Throwable t) {
                addIdCard.postValue(null);
            }
        });
    }

    /* Get */

    public MutableLiveData<Types.AccountResponse> getAccountSelf() {
        return accountSelf;
    }

    public MutableLiveData<Types.AccountResponse> getAccountDetails() {
        return accountDetails;
    }

    public MutableLiveData<Types.RegisterResponse> getAccountsRegister() {
        return accountsRegister;
    }

    public MutableLiveData<Types.LoginResponse> getAccountsLogin() {
        return accountsLogin;
    }

    public MutableLiveData<Types.ObjectResponse> getAccountsLogout() {
        return accountsLogout;
    }

    public MutableLiveData<Types.ObjectResponse> getAccountsLogoutAll() {
        return accountsLogoutAll;
    }

    public MutableLiveData<Types.PhotoResponse> getPhoto() {
        return photo;
    }

    public MutableLiveData<Types.PhotoResponse> getAddPhoto() {
        return addPhoto;
    }

    public MutableLiveData<Types.IdCardListResponse> getIdCardList() {
        return idCardList;
    }

    public MutableLiveData<Types.IdCardResponse> getAddIdCard() {
        return addIdCard;
    }
}
