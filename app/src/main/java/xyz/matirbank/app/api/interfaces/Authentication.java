package xyz.matirbank.app.api.interfaces;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import xyz.matirbank.app.entities.api.accounts.Register;

public interface Authentication {

    @POST("/accounts/register/")
    Call<Response> accountRegister(@Body Register request);
}
