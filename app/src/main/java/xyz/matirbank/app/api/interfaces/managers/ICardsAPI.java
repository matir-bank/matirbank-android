package xyz.matirbank.app.api.interfaces.managers;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.api.entities.accounts.requests.Register;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.DeleteResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cards.requests.CardRequest;
import xyz.matirbank.app.api.entities.cards.responses.CardResponse;

public interface ICardsAPI {

    void cards(Callback<ResponseContainer<List<CardResponse>>> callback);
    void createCard(CardRequest request, Callback<ResponseContainer<CardResponse>> callback);
    void readCard(String request, Callback<ResponseContainer<CardResponse>> callback);
    void updateCard(String request, Callback<ResponseContainer<CardResponse>> callback);
    void deleteCard(String request, Callback<ResponseContainer<DeleteResponse>> callback);

}
