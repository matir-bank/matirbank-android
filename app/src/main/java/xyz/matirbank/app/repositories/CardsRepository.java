package xyz.matirbank.app.repositories;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.interfaces.Types;
import xyz.matirbank.app.api.entities.cards.requests.CardRequest;
import xyz.matirbank.app.api.interfaces.ICards;
import xyz.matirbank.app.services.interfaces.IRetrofitService;

public class CardsRepository {

    @Inject
    IRetrofitService _retrofitService;
    private final ICards cardsAPI;

    private final MutableLiveData<Types.CardListResponse> cardList = new MutableLiveData<>();
    private final MutableLiveData<Types.CardResponse> createCard = new MutableLiveData<>();
    private final MutableLiveData<Types.CardResponse> readCard = new MutableLiveData<>();
    private final MutableLiveData<Types.CardResponse> updateCard = new MutableLiveData<>();
    private final MutableLiveData<Types.DeleteResponse> deleteCard = new MutableLiveData<>();

    public CardsRepository() {
        ThisApplication.getInstance().getComponents().inject(this);
        cardsAPI = _retrofitService.getClient().create(ICards.class);
    }

    /* Request */

    public void cards() {
        cardsAPI.cardList().enqueue(new Callback<Types.CardListResponse>() {
            @Override
            public void onResponse(Call<Types.CardListResponse> call, Response<Types.CardListResponse> response) {
                cardList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.CardListResponse> call, Throwable t) {
                cardList.postValue(null);
            }
        });
    }

    public void createCard(CardRequest request) {
        cardsAPI.createCard(request).enqueue(new Callback<Types.CardResponse>() {
            @Override
            public void onResponse(Call<Types.CardResponse> call, Response<Types.CardResponse> response) {
                createCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.CardResponse> call, Throwable t) {
                createCard.postValue(null);
            }
        });
    }

    public void readCard(String request) {
        cardsAPI.readCard(request).enqueue(new Callback<Types.CardResponse>() {
            @Override
            public void onResponse(Call<Types.CardResponse> call, Response<Types.CardResponse> response) {
                readCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.CardResponse> call, Throwable t) {
                readCard.postValue(null);
            }
        });
    }

    public void updateCard(String request, CardRequest requestBody) {
        cardsAPI.updateCard(request, requestBody).enqueue(new Callback<Types.CardResponse>() {
            @Override
            public void onResponse(Call<Types.CardResponse> call, Response<Types.CardResponse> response) {
                updateCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.CardResponse> call, Throwable t) {
                updateCard.postValue(null);
            }
        });
    }

    public void deleteCard(String request) {
        cardsAPI.deleteCard(request).enqueue(new Callback<Types.DeleteResponse>() {
            @Override
            public void onResponse(Call<Types.DeleteResponse> call, Response<Types.DeleteResponse> response) {
                deleteCard.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Types.DeleteResponse> call, Throwable t) {
                deleteCard.postValue(null);
            }
        });
    }

    /* Get */

    public MutableLiveData<Types.CardListResponse> getCardList() {
        return cardList;
    }

    public MutableLiveData<Types.CardResponse> getCreateCard() {
        return createCard;
    }

    public MutableLiveData<Types.CardResponse> getReadCard() {
        return readCard;
    }

    public MutableLiveData<Types.CardResponse> getUpdateCard() {
        return updateCard;
    }

    public MutableLiveData<Types.DeleteResponse> getDeleteCard() {
        return deleteCard;
    }
}
