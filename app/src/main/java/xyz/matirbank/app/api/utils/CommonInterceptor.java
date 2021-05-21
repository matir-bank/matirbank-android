package xyz.matirbank.app.api.utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import xyz.matirbank.app.BuildConfig;
import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.utils.CommonConstants;

public class CommonInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        String request_url = request.url().toString();

        // Place Authorization Token
        if(!CommonConstants.AUTH_TOKEN.equals("")){
            request = request.newBuilder()
                    .addHeader("Authorization", "Token ".concat(CommonConstants.AUTH_TOKEN))
                    .build();
        }

        // Remove Authorization for Register / Login
        if(request_url.contains("/accounts/register/") || request_url.contains("/accounts/login/")) {
            request = request.newBuilder()
                    .removeHeader("Authorization")
                    .build();
        }

        // Add Client Information to Header
        request = request.newBuilder()
                .addHeader("App-Package", BuildConfig.APPLICATION_ID)
                .addHeader("App-VersionCode", String.valueOf(BuildConfig.VERSION_CODE))
                .addHeader("App-VersionName", BuildConfig.VERSION_NAME)
                .build();

        // Proceed to Response
        Response response = chain.proceed(request);

        // Goto Login Page if Session Expired
        if(response.code() == 401){
            ThisApplication.gotoLogin();
        }

        return response;
    }

}
