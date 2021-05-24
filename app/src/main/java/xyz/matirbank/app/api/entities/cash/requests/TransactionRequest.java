package xyz.matirbank.app.api.entities.cash.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionRequest {
    @SerializedName("destination")
    @Expose
    int destination;
    @SerializedName("amount")
    @Expose
    double amount;

    public int getDestination() {
        return destination;
    }

    public TransactionRequest setDestination(int destination) {
        this.destination = destination;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionRequest setAmount(double amount) {
        this.amount = amount;
        return this;
    }
}
