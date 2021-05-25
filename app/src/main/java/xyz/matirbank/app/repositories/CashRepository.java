package xyz.matirbank.app.repositories;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.Types;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;
import xyz.matirbank.app.api.interfaces.ICash;
import xyz.matirbank.app.services.interfaces.IRetrofitService;

public class CashRepository {

    @Inject
    IRetrofitService _retrofitService;
    private final ICash cashAPI;

    private final MutableLiveData<Types.TransactionListResponse> transactionList = new MutableLiveData<>();
    private final MutableLiveData<Types.TransactionResponse> transactionCreate = new MutableLiveData<>();
    private final MutableLiveData<Types.TransactionResponse> transactionDetails = new MutableLiveData<>();
    private final MutableLiveData<Types.AddFundResponse> addFund = new MutableLiveData<>();
    private final MutableLiveData<Types.TransactionResponse> topUp = new MutableLiveData<>();

    public CashRepository() {
        ThisApplication.getInstance().getComponents().inject(this);
        cashAPI = _retrofitService.getClient().create(ICash.class);
    }

    public void transactionList() {
        cashAPI.transactionList().enqueue(new Callback<Types.TransactionListResponse>() {
            @Override
            public void onResponse(Call<Types.TransactionListResponse> call, Response<Types.TransactionListResponse> response) {
                transactionList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.TransactionListResponse> call, Throwable t) {
                transactionList.postValue(null);
            }
        });
    }

    public void transactionCreate(TransactionRequest request) {
        cashAPI.transactionCreate(request).enqueue(new Callback<Types.TransactionResponse>() {
            @Override
            public void onResponse(Call<Types.TransactionResponse> call, Response<Types.TransactionResponse> response) {
                transactionCreate.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.TransactionResponse> call, Throwable t) {
                transactionCreate.postValue(null);
            }
        });
    }

    public void transactionDetails(int request) {
        cashAPI.transactionDetails(request).enqueue(new Callback<Types.TransactionResponse>() {
            @Override
            public void onResponse(Call<Types.TransactionResponse> call, Response<Types.TransactionResponse> response) {
                transactionDetails.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.TransactionResponse> call, Throwable t) {
                transactionDetails.postValue(null);
            }
        });
    }

    public void addFund(AddFundRequest request) {
        cashAPI.addFund(request).enqueue(new Callback<Types.AddFundResponse>() {
            @Override
            public void onResponse(Call<Types.AddFundResponse> call, Response<Types.AddFundResponse> response) {
                addFund.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.AddFundResponse> call, Throwable t) {
                addFund.postValue(null);
            }
        });
    }

    public void topUp(TopUpRequest request) {
        cashAPI.topUp(request).enqueue(new Callback<Types.TransactionResponse>() {
            @Override
            public void onResponse(Call<Types.TransactionResponse> call, Response<Types.TransactionResponse> response) {
                topUp.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.TransactionResponse> call, Throwable t) {
                topUp.postValue(null);
            }
        });
    }

    /* Get */

    public MutableLiveData<Types.TransactionListResponse> getTransactionList() {
        return transactionList;
    }

    public MutableLiveData<Types.TransactionResponse> getTransactionCreate() {
        return transactionCreate;
    }

    public MutableLiveData<Types.TransactionResponse> getTransactionDetails() {
        return transactionDetails;
    }

    public MutableLiveData<Types.AddFundResponse> getAddFund() {
        return addFund;
    }

    public MutableLiveData<Types.TransactionResponse> getTopUp() {
        return topUp;
    }
}
