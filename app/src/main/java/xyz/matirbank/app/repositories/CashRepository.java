package xyz.matirbank.app.repositories;

import androidx.lifecycle.MutableLiveData;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;
import xyz.matirbank.app.api.entities.cash.responses.AddFundResponse;
import xyz.matirbank.app.api.entities.cash.responses.TransactionResponse;
import xyz.matirbank.app.api.interfaces.managers.ICashAPI;

public class CashRepository {

    @Inject
    ICashAPI cashAPI;

    private final MutableLiveData<ResponseContainer<List<TransactionResponse>>> transactionList = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<TransactionResponse>> transactionCreate = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<TransactionResponse>> transactionDetails = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<AddFundResponse>> addFund = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<TransactionResponse>> topUp = new MutableLiveData<>();

    public CashRepository() {
        ThisApplication.getInstance().getComponents().inject(this);
    }

    public void transactionList() {
        cashAPI.transactionList(new Callback<ResponseContainer<List<TransactionResponse>>>() {
            @Override
            public void onResponse(Call<ResponseContainer<List<TransactionResponse>>> call, Response<ResponseContainer<List<TransactionResponse>>> response) {
                transactionList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<List<TransactionResponse>>> call, Throwable t) {
                transactionList.postValue(null);
            }
        });
    }

    public void transactionCreate(TransactionRequest request) {
        cashAPI.transactionCreate(request, new Callback<ResponseContainer<TransactionResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<TransactionResponse>> call, Response<ResponseContainer<TransactionResponse>> response) {
                transactionCreate.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<TransactionResponse>> call, Throwable t) {
                transactionCreate.postValue(null);
            }
        });
    }

    public void transactionDetails(int request) {
        cashAPI.transactionDetails(request, new Callback<ResponseContainer<TransactionResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<TransactionResponse>> call, Response<ResponseContainer<TransactionResponse>> response) {
                transactionDetails.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<TransactionResponse>> call, Throwable t) {
                transactionDetails.postValue(null);
            }
        });
    }

    public void addFund(AddFundRequest request) {
        cashAPI.addFund(request, new Callback<ResponseContainer<AddFundResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<AddFundResponse>> call, Response<ResponseContainer<AddFundResponse>> response) {
                addFund.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<AddFundResponse>> call, Throwable t) {
                addFund.postValue(null);
            }
        });
    }

    public void topUp(TopUpRequest request) {
        cashAPI.topUp(request, new Callback<ResponseContainer<TransactionResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<TransactionResponse>> call, Response<ResponseContainer<TransactionResponse>> response) {
                topUp.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<TransactionResponse>> call, Throwable t) {
                topUp.postValue(null);
            }
        });
    }

    public MutableLiveData<ResponseContainer<List<TransactionResponse>>> getTransactionList() {
        return transactionList;
    }

    public MutableLiveData<ResponseContainer<TransactionResponse>> getTransactionCreate() {
        return transactionCreate;
    }

    public MutableLiveData<ResponseContainer<TransactionResponse>> getTransactionDetails() {
        return transactionDetails;
    }

    public MutableLiveData<ResponseContainer<AddFundResponse>> getAddFund() {
        return addFund;
    }

    public MutableLiveData<ResponseContainer<TransactionResponse>> getTopUp() {
        return topUp;
    }
}
