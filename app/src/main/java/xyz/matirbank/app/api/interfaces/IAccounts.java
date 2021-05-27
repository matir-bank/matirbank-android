package xyz.matirbank.app.api.interfaces;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;

public interface IAccounts {

    @GET("/accounts/")
    Call<Types.AccountResponse> accountSelf();

    @GET("/accounts/")
    Call<Types.AccountResponse> accountsDetails(@Query("phone") String request);

    @POST("/accounts/register/")
    Call<Types.RegisterResponse> accountsRegister(@Body RegisterRequest request);

    @POST("/accounts/login/")
    Call<Types.LoginResponse> accountsLogin(@Body LoginRequest request);

    @GET("/accounts/logout/")
    Call<Types.ObjectResponse> accountsLogout();

    @GET("/accounts/logoutall/")
    Call<Types.ObjectResponse> accountsLogoutAll();

    @GET("/photo/")
    Call<Types.PhotoResponse> photo();

    @Multipart
    @POST("/photo/")
    Call<Types.PhotoResponse> addPhoto(@Part MultipartBody.Part file);

    @GET("/id_card/")
    Call<Types.IdCardListResponse> idCardList();

    @Multipart
    @POST("/id_card/")
    Call<Types.IdCardResponse> addIdCard(@Part MultipartBody.Part type, @Part MultipartBody.Part file);

}
