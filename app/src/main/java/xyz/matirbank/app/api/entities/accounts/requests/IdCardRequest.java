package xyz.matirbank.app.api.entities.accounts.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdCardRequest {

    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public IdCardRequest setType(String type) {
        this.type = type;
        return this;
    }

}
