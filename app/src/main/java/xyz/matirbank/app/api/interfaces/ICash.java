package xyz.matirbank.app.api.interfaces;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;

public interface ICash {

    @GET("/transaction/")
    Call<Types.TransactionListResponse> transactionList();

    @GET("/transaction/{id}/")
    Call<Types.TransactionResponse> transactionDetails(@Path("id") int request);

    @POST("/transaction/do/send-money/")
    Call<Types.TransactionResponse> transactionCreate(@Body TransactionRequest request);

    @POST("/transaction/do/add-fund/")
    Call<Types.AddFundResponse> addFund(@Body AddFundRequest request);

    @POST("/transaction/do/top-up/")
    Call<Types.TransactionResponse> topUp(@Body TopUpRequest request);

}
