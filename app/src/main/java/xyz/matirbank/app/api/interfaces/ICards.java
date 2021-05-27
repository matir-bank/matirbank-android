package xyz.matirbank.app.api.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import retrofit2.http.Body;
import xyz.matirbank.app.api.entities.cards.requests.CardRequest;

public interface ICards {

    @GET("/cards/")
    Call<Types.CardListResponse> cardList();

    @POST("/cards/")
    Call<Types.CardResponse> createCard(@Body CardRequest request);

    @GET("/cards/{card_id}/")
    Call<Types.CardResponse> readCard(@Path("card_id") String request);

    @POST("/cards/{card_id}/")
    Call<Types.CardResponse> updateCard(@Path("card_id") String request, @Body CardRequest requestBody);

    @DELETE("/cards/{card_id}/")
    Call<Types.DeleteResponse> deleteCard(@Path("card_id") String request);

}
