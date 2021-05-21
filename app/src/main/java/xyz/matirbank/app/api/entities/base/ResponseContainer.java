package xyz.matirbank.app.api.entities.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseContainer<T> {

    @SerializedName("status")
    @Expose
    int status;

    @SerializedName("data")
    @Expose
    T data;

    @SerializedName("error")
    @Expose
    Error error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}
