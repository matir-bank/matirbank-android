package xyz.matirbank.app.api.managers;

import java.util.List;
import javax.inject.Inject;
import retrofit2.Callback;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;
import xyz.matirbank.app.api.entities.cash.responses.AddFundResponse;
import xyz.matirbank.app.api.entities.cash.responses.TransactionResponse;
import xyz.matirbank.app.api.interfaces.apis.ICash;
import xyz.matirbank.app.api.interfaces.managers.ICashAPI;
import xyz.matirbank.app.services.interfaces.IRetrofitService;

public class CashAPI implements ICashAPI {

    @Inject
    IRetrofitService _retrofitService;
    ICash cash  = _retrofitService.getClient().create(ICash.class);

    public CashAPI() {
        ThisApplication.getInstance().getComponents().inject(this);
    }

    @Override
    public void transactionList(Callback<ResponseContainer<List<TransactionResponse>>> callback) {
        cash.transactionList().enqueue(callback);
    }

    @Override
    public void transactionCreate(TransactionRequest request, Callback<ResponseContainer<TransactionResponse>> callback) {
        cash.transactionCreate(request).enqueue(callback);
    }

    @Override
    public void transactionDetails(int request, Callback<ResponseContainer<TransactionResponse>> callback) {
        cash.transactionDetails(request).enqueue(callback);
    }

    @Override
    public void addFund(AddFundRequest request, Callback<ResponseContainer<AddFundResponse>> callback) {
        cash.addFund(request).enqueue(callback);
    }

    @Override
    public void topUp(TopUpRequest request, Callback<ResponseContainer<TransactionResponse>> callback) {
        cash.topUp(request).enqueue(callback);
    }

}
