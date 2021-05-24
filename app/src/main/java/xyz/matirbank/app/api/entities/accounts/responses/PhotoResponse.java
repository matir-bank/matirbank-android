package xyz.matirbank.app.api.entities.accounts.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user")
    @Expose
    private Integer user;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public PhotoResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUser() {
        return user;
    }

    public PhotoResponse setUser(Integer user) {
        this.user = user;
        return this;
    }

    public String getImage() {
        return image;
    }

    public PhotoResponse setImage(String image) {
        this.image = image;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public PhotoResponse setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public PhotoResponse setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
