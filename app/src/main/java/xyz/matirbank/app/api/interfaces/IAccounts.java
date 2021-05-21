package xyz.matirbank.app.api.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import xyz.matirbank.app.entities.api.accounts.Login;
import xyz.matirbank.app.entities.api.accounts.Register;

public interface IAccounts {

    @GET("/accounts")
    Call<ResponseBody> account();

    @POST("/accounts/register/")
    Call<ResponseBody> accountsRegister(@Body Register request);

    @POST("/accounts/login/")
    Call<ResponseBody> accountsLogin(@Body Login request);

    @GET("/accounts/logout/")
    Call<ResponseBody> accountsLogout();

    @GET("/accounts/logoutall/")
    Call<ResponseBody> accountsLogoutAll();

}
