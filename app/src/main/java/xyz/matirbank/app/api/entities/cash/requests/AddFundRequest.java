package xyz.matirbank.app.api.entities.cash.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddFundRequest {

    @SerializedName("amount")
    @Expose
    double amount;
    @SerializedName("card_id")
    @Expose
    int card_id;

    public double getAmount() {
        return amount;
    }

    public AddFundRequest setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public int getCard_id() {
        return card_id;
    }

    public AddFundRequest setCard_id(int card_id) {
        this.card_id = card_id;
        return this;
    }
}
