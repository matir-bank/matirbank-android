package xyz.matirbank.app.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.base.DeleteResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cards.requests.CardRequest;
import xyz.matirbank.app.api.entities.cards.responses.CardResponse;
import xyz.matirbank.app.api.interfaces.managers.ICardsAPI;

public class CardsRepository {

    @Inject
    ICardsAPI cardsAPI;

    private final MutableLiveData<ResponseContainer<List<CardResponse>>> cards = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<CardResponse>> createCard = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<CardResponse>> readCard = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<CardResponse>> updateCard = new MutableLiveData<>();
    private final MutableLiveData<ResponseContainer<DeleteResponse>> deleteCard = new MutableLiveData<>();

    public CardsRepository() {
        ThisApplication.getInstance().getComponents().inject(this);
    }

    public void cards() {
        cardsAPI.cards(new Callback<ResponseContainer<List<CardResponse>>>() {
            @Override
            public void onResponse(Call<ResponseContainer<List<CardResponse>>> call, Response<ResponseContainer<List<CardResponse>>> response) {
                cards.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<List<CardResponse>>> call, Throwable t) {
                cards.postValue(null);
            }
        });
    }

    public void createCard(CardRequest request) {
        cardsAPI.createCard(request, new Callback<ResponseContainer<CardResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<CardResponse>> call, Response<ResponseContainer<CardResponse>> response) {
                createCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<CardResponse>> call, Throwable t) {
                createCard.postValue(null);
            }
        });
    }

    public void readCard(String request) {
        cardsAPI.readCard(request, new Callback<ResponseContainer<CardResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<CardResponse>> call, Response<ResponseContainer<CardResponse>> response) {
                readCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<CardResponse>> call, Throwable t) {
                readCard.postValue(null);
            }
        });
    }

    public void updateCard(String request) {
        cardsAPI.updateCard(request, new Callback<ResponseContainer<CardResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<CardResponse>> call, Response<ResponseContainer<CardResponse>> response) {
                updateCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<CardResponse>> call, Throwable t) {
                updateCard.postValue(null);
            }
        });
    }

    public void deleteCard(String request) {
        cardsAPI.deleteCard(request, new Callback<ResponseContainer<DeleteResponse>>() {
            @Override
            public void onResponse(Call<ResponseContainer<DeleteResponse>> call, Response<ResponseContainer<DeleteResponse>> response) {
                deleteCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseContainer<DeleteResponse>> call, Throwable t) {
                deleteCard.postValue(null);
            }
        });
    }

    public MutableLiveData<ResponseContainer<List<CardResponse>>> getCards() {
        return cards;
    }

    public MutableLiveData<ResponseContainer<CardResponse>> getCreateCard() {
        return createCard;
    }

    public MutableLiveData<ResponseContainer<CardResponse>> getReadCard() {
        return readCard;
    }

    public MutableLiveData<ResponseContainer<CardResponse>> getUpdateCard() {
        return updateCard;
    }

    public MutableLiveData<ResponseContainer<DeleteResponse>> getDeleteCard() {
        return deleteCard;
    }
}
