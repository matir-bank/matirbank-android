package xyz.matirbank.app.api.managers;

import java.util.List;
import javax.inject.Inject;
import retrofit2.Callback;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.base.DeleteResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cards.requests.CardRequest;
import xyz.matirbank.app.api.entities.cards.responses.CardResponse;
import xyz.matirbank.app.api.interfaces.apis.ICards;
import xyz.matirbank.app.api.interfaces.managers.ICardsAPI;
import xyz.matirbank.app.services.interfaces.IRetrofitService;

public class CardsAPI implements ICardsAPI {

    @Inject
    IRetrofitService _retrofitService;
    ICards cards = _retrofitService.getClient().create(ICards.class);

    public CardsAPI() {
        ThisApplication.getInstance().getComponents().inject(this);
    }

    @Override
    public void cards(Callback<ResponseContainer<List<CardResponse>>> callback) {
        cards.cards().enqueue(callback);
    }

    @Override
    public void createCard(CardRequest request, Callback<ResponseContainer<CardResponse>> callback) {
        cards.createCard(request).enqueue(callback);
    }

    @Override
    public void readCard(String request, Callback<ResponseContainer<CardResponse>> callback) {
        cards.readCard(request).enqueue(callback);
    }

    @Override
    public void updateCard(String request, Callback<ResponseContainer<CardResponse>> callback) {
        cards.updateCard(request).enqueue(callback);
    }

    @Override
    public void deleteCard(String request, Callback<ResponseContainer<DeleteResponse>> callback) {
        cards.deleteCard(request).enqueue(callback);
    }
}
