package xyz.matirbank.app.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import xyz.matirbank.app.api.entities.base.DeleteResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cards.requests.CardRequest;
import xyz.matirbank.app.api.entities.cards.responses.CardResponse;
import xyz.matirbank.app.repositories.CardsRepository;

public class CardsViewModel extends AndroidViewModel {

    private final CardsRepository cardsRepository = new CardsRepository();
    private final LiveData<ResponseContainer<List<CardResponse>>> cards = cardsRepository.getCards();
    private final LiveData<ResponseContainer<CardResponse>> createCard = cardsRepository.getCreateCard();
    private final LiveData<ResponseContainer<CardResponse>> readCard = cardsRepository.getReadCard();
    private final LiveData<ResponseContainer<CardResponse>> updateCard = cardsRepository.getUpdateCard();
    private final LiveData<ResponseContainer<DeleteResponse>> deleteCard = cardsRepository.getDeleteCard();

    public CardsViewModel(@NonNull Application application) {
        super(application);
    }

    public void cards() {
        cardsRepository.cards();
    }

    public void createCard(CardRequest request) {
        cardsRepository.createCard(request);
    }

    public void readCard(String request) {
        cardsRepository.readCard(request);
    }

    public void updateCard(String request) {
        cardsRepository.updateCard(request);
    }

    public void deleteCard(String request) {
        cardsRepository.deleteCard(request);
    }

    public LiveData<ResponseContainer<List<CardResponse>>> getCards() {
        return cards;
    }

    public LiveData<ResponseContainer<CardResponse>> getCreateCard() {
        return createCard;
    }

    public LiveData<ResponseContainer<CardResponse>> getReadCard() {
        return readCard;
    }

    public LiveData<ResponseContainer<CardResponse>> getUpdateCard() {
        return updateCard;
    }

    public LiveData<ResponseContainer<DeleteResponse>> getDeleteCard() {
        return deleteCard;
    }
}
