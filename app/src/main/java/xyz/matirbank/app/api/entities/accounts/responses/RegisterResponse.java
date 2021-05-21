package xyz.matirbank.app.api.entities.accounts.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("user")
    @Expose
    AccountResponse user;
    @SerializedName("token")
    @Expose
    String token;

    public AccountResponse getUser() {
        return user;
    }

    public void setUser(AccountResponse user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
