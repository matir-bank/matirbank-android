package xyz.matirbank.app.presentation.activities.common;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.presentation.viewmodels.SplashViewModel;
import xyz.matirbank.app.presentation.activities.accounts.LoginActivity;
import xyz.matirbank.app.databinding.ActivitySplashBinding;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class SplashActivity extends AppCompatActivity {

    SplashViewModel splashViewModel;
    public ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init Dagger
        ThisApplication.getInstance().getComponents().inject(this);

        // Init ViewModel
        splashViewModel = new SplashViewModel(this);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPhone("adminx");
        loginRequest.setPassword("adminphone");
        splashViewModel.getAccountsViewModel().accountsLogin(loginRequest);
        splashViewModel.getAccountsViewModel().account();
        splashViewModel.getAccountsViewModel().accountDetails("admin");
        splashViewModel.getAccountsViewModel().accountsLogout();

        // Bind View
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Animate Views
        animateViews();

        // Go To Login
        try {
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                try {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    //Intent intent = new Intent(SplashActivity.this, TestActivity.class);
                    intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP|FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }, 3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void animateViews() {
        ObjectAnimator.ofFloat(binding.imgIcon, "alpha", 0, 1).setDuration(1200).start();
        ObjectAnimator.ofFloat(binding.txMatirBank, "translationX", 500, 0).setDuration(1000).start();
        ObjectAnimator.ofFloat(binding.txMobileFinancialService, "translationX", -500, 0).setDuration(1000).start();
    }
}