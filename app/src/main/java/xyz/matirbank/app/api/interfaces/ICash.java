package xyz.matirbank.app.api.interfaces;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import xyz.matirbank.app.api.entities.Types;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;

public interface ICash {

    @GET("/transaction/")
    Call<Types.TransactionListResponse> transactionList();

    @POST("/transaction/")
    Call<Types.TransactionResponse> transactionCreate(@Body TransactionRequest request);

    @GET("/transaction/{id}/")
    Call<Types.TransactionResponse> transactionDetails(@Path("id") int request);

    @POST("/add-fund/")
    Call<Types.AddFundResponse> addFund(@Body AddFundRequest request);

    @POST("/top-up/")
    Call<Types.TransactionResponse> topUp(@Body TopUpRequest request);

}
