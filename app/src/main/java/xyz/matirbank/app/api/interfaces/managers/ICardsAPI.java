package xyz.matirbank.app.api.interfaces.managers;

import java.util.List;

import retrofit2.Callback;
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
