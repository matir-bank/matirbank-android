package xyz.matirbank.app.api.interfaces.apis;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.IdCardResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;
import xyz.matirbank.app.api.entities.accounts.responses.PhotoResponse;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;

public interface IAccounts {

    @GET("/accounts/")
    Call<ResponseContainer<AccountResponse>> accountsList();

    @GET("/accounts/")
    Call<ResponseContainer<AccountResponse>> accountsDetails(@Query("phone") String request);

    @POST("/accounts/register/")
    Call<ResponseContainer<RegisterResponse>> accountsRegister(@Body RegisterRequest request);

    @POST("/accounts/login/")
    Call<ResponseContainer<LoginResponse>> accountsLogin(@Body LoginRequest request);

    @GET("/accounts/logout/")
    Call<ResponseContainer<Object>> accountsLogout();

    @GET("/accounts/logoutall/")
    Call<ResponseContainer<Object>> accountsLogoutAll();

    @GET("/photo/")
    Call<ResponseContainer<PhotoResponse>> photo();

    @Multipart
    @POST("/photo/")
    Call<ResponseContainer<PhotoResponse>> addPhoto(@Part MultipartBody.Part file);

    @GET("/id_card/")
    Call<ResponseContainer<List<IdCardResponse>>> idCardList();

    @Multipart
    @POST("/id_card/")
    Call<ResponseContainer<IdCardResponse>> addIdCard(@Part MultipartBody.Part type, @Part MultipartBody.Part file);

}
