package xyz.matirbank.app.api.entities.cards.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardRequest {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("card_no")
    @Expose
    private String cardNo;
    @SerializedName("validity")
    @Expose
    private String validity;
    @SerializedName("cvv")
    @Expose
    private String cvv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

}