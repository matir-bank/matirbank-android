package xyz.matirbank.app.api.entities.cash.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddFundResponse {

    @SerializedName("amount")
    @Expose
    double amount;
    @SerializedName("card_id")
    @Expose
    int card_id;

    public double getAmount() {
        return amount;
    }

    public AddFundResponse setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public int getCard_id() {
        return card_id;
    }

    public AddFundResponse setCard_id(int card_id) {
        this.card_id = card_id;
        return this;
    }
}
