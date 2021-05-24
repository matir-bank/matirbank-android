package xyz.matirbank.app.api.interfaces.managers;

import java.util.List;
import retrofit2.Callback;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;
import xyz.matirbank.app.api.entities.cash.responses.AddFundResponse;
import xyz.matirbank.app.api.entities.cash.responses.TransactionResponse;

public interface ICashAPI {

    void transactionList(Callback<ResponseContainer<List<TransactionResponse>>> callback);
    void transactionCreate(TransactionRequest request, Callback<ResponseContainer<TransactionResponse>> callback);
    void transactionDetails(int request, Callback<ResponseContainer<TransactionResponse>> callback);
    void addFund(AddFundRequest request, Callback<ResponseContainer<AddFundResponse>> callback);
    void topUp(TopUpRequest request, Callback<ResponseContainer<TransactionResponse>> callback);

}
