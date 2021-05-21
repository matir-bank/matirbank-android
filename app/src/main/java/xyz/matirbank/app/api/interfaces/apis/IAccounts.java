package xyz.matirbank.app.api.interfaces.apis;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.api.entities.accounts.responses.AccountResponse;
import xyz.matirbank.app.api.entities.accounts.responses.LoginResponse;
import xyz.matirbank.app.api.entities.accounts.requests.Register;
import xyz.matirbank.app.api.entities.accounts.responses.RegisterResponse;
import xyz.matirbank.app.api.entities.base.ResponseContainer;

public interface IAccounts {

    @GET("/accounts/")
    Call<ResponseContainer<AccountResponse>> account();

    @GET("/accounts/")
    Call<ResponseContainer<AccountResponse>> accountDetails(@Query("phone") String request);

    @POST("/accounts/register/")
    Call<ResponseContainer<RegisterResponse>> accountsRegister(@Body Register request);

    @POST("/accounts/login/")
    Call<ResponseContainer<LoginResponse>> accountsLogin(@Body Login request);

    @GET("/accounts/logout/")
    Call<ResponseContainer<Object>> accountsLogout();

    @GET("/accounts/logoutall/")
    Call<ResponseContainer<Object>> accountsLogoutAll();

}
