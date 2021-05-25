package xyz.matirbank.app.api.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;
import xyz.matirbank.app.api.entities.cash.responses.AddFundResponse;
import xyz.matirbank.app.api.entities.cash.responses.TransactionResponse;

public interface ICash {

    @GET("/transaction/")
    Call<ResponseContainer<List<TransactionResponse>>> transactionList();

    @POST("/transaction/")
    Call<ResponseContainer<TransactionResponse>> transactionCreate(@Body TransactionRequest request);

    @GET("/transaction/{id}/")
    Call<ResponseContainer<TransactionResponse>> transactionDetails(@Path("id") int request);

    @POST("/add-fund/")
    Call<ResponseContainer<AddFundResponse>> addFund(@Body AddFundRequest request);

    @POST("/top-up/")
    Call<ResponseContainer<TransactionResponse>> topUp(@Body TopUpRequest request);

}
