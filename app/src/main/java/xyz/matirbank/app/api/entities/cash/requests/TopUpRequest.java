package xyz.matirbank.app.api.entities.cash.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopUpRequest {

    @SerializedName("operator")
    @Expose
    String operator;
    @SerializedName("mobile")
    @Expose
    String mobile;
    @SerializedName("amount")
    @Expose
    double amount;

    public String getOperator() {
        return operator;
    }

    public TopUpRequest setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public TopUpRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public TopUpRequest setAmount(double amount) {
        this.amount = amount;
        return this;
    }

}
