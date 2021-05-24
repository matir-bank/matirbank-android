package xyz.matirbank.app.api.entities.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteResponse {

    @SerializedName("detail")
    @Expose
    String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
