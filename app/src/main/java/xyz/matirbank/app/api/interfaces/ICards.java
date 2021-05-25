package xyz.matirbank.app.api.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import retrofit2.http.Body;
import xyz.matirbank.app.api.entities.base.DeleteResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cards.requests.CardRequest;
import xyz.matirbank.app.api.entities.cards.responses.CardResponse;

public interface ICards {

    @GET("/cards/")
    Call<ResponseContainer<List<CardResponse>>> cardList();

    @POST("/cards/")
    Call<ResponseContainer<CardResponse>> createCard(@Body CardRequest request);

    @GET("/cards/{card_id}/")
    Call<ResponseContainer<CardResponse>> readCard(@Path("card_id") String request);

    @GET("/cards/{card_id}/")
    Call<ResponseContainer<CardResponse>> updateCard(@Path("card_id") String request);

    @DELETE("/cards/{card_id}/")
    Call<ResponseContainer<DeleteResponse>> deleteCard(@Path("card_id") String request);

}
