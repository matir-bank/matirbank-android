package xyz.matirbank.app.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import xyz.matirbank.app.api.entities.Types;
import xyz.matirbank.app.api.entities.cards.requests.CardRequest;
import xyz.matirbank.app.repositories.CardsRepository;

public class CardsViewModel extends AndroidViewModel {

    private final CardsRepository cardsRepository = new CardsRepository();
    private final LiveData<Types.CardListResponse> cards = cardsRepository.getCardList();
    private final LiveData<Types.CardResponse> createCard = cardsRepository.getCreateCard();
    private final LiveData<Types.CardResponse> readCard = cardsRepository.getReadCard();
    private final LiveData<Types.CardResponse> updateCard = cardsRepository.getUpdateCard();
    private final LiveData<Types.DeleteResponse> deleteCard = cardsRepository.getDeleteCard();

    public CardsViewModel(@NonNull Application application) {
        super(application);
    }

    /* Request */

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

    /* Get */

    public LiveData<Types.CardListResponse> getCards() {
        return cards;
    }

    public LiveData<Types.CardResponse> getCreateCard() {
        return createCard;
    }

    public LiveData<Types.CardResponse> getReadCard() {
        return readCard;
    }

    public LiveData<Types.CardResponse> getUpdateCard() {
        return updateCard;
    }

    public LiveData<Types.DeleteResponse> getDeleteCard() {
        return deleteCard;
    }
}
