package xyz.matirbank.app.api.interfaces;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import xyz.matirbank.app.entities.api.accounts.Login;
import xyz.matirbank.app.entities.api.accounts.Register;

public interface IAccounts {

    @POST("/accounts/register/")
    Call<Response> accountsRegister(@Body Register request);

    @POST("/accounts/login/")
    Call<Response> accountsLogin(@Body Login request);

    @GET("/accounts/logout/")
    Call<Response> accountsLogout();

    @GET("/accounts/logoutall/")
    Call<Response> accountsLogoutAll();

}
