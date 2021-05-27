package xyz.matirbank.app.api.interfaces;

import java.util.List;
import xyz.matirbank.app.api.entities.base.ResponseContainer;

public interface Types {

    class ObjectResponse extends ResponseContainer<Object> {}

    class AccountResponse extends ResponseContainer<xyz.matirbank.app.api.entities.accounts.responses.AccountResponse> {}
    class RegisterResponse extends ResponseContainer<xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse> {}
    class LoginResponse extends ResponseContainer<xyz.matirbank.app.api.entities.accounts.responses.LoginResponse> {}
    class PhotoResponse extends ResponseContainer<xyz.matirbank.app.api.entities.accounts.responses.PhotoResponse> {}
    class IdCardResponse extends ResponseContainer<xyz.matirbank.app.api.entities.accounts.responses.IdCardResponse> {}
    class IdCardListResponse extends ResponseContainer<List<xyz.matirbank.app.api.entities.accounts.responses.IdCardResponse>> {}

    class CardResponse extends ResponseContainer<xyz.matirbank.app.api.entities.cards.responses.CardResponse> {}
    class CardListResponse extends ResponseContainer<List<xyz.matirbank.app.api.entities.cards.responses.CardResponse>> {}
    class DeleteResponse extends ResponseContainer<xyz.matirbank.app.api.entities.base.DeleteResponse> {}

    class TransactionResponse extends ResponseContainer<xyz.matirbank.app.api.entities.cash.responses.TransactionResponse> {}
    class TransactionListResponse extends ResponseContainer<List<xyz.matirbank.app.api.entities.cash.responses.TransactionResponse>> {}
    class AddFundResponse extends ResponseContainer<xyz.matirbank.app.api.entities.cash.responses.AddFundResponse> {}

}
