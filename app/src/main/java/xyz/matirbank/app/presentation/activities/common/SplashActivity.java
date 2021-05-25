package xyz.matirbank.app.presentation.activities.common;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.presentation.viewmodels.SplashViewModel;
import xyz.matirbank.app.presentation.activities.accounts.LoginActivity;
import xyz.matirbank.app.databinding.ActivitySplashBinding;
import xyz.matirbank.app.api.entities.accounts.requests.LoginRequest;
import xyz.matirbank.app.services.interfaces.ISharedPreference;
import xyz.matirbank.app.utils.CommonConstants;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class SplashActivity extends AppCompatActivity {

    @Inject
    ISharedPreference _sharedPreference;
    
    SplashViewModel splashViewModel;
    public ActivitySplashBinding binding;
    public boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init Dagger
        ThisApplication.getInstance().getComponents().inject(this);

        // Bind View
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonConstants.AUTH_TOKEN = _sharedPreference.loadPreference("_AUTH_TOKEN", "");
        CommonConstants.AUTH_EXPIRES = _sharedPreference.loadPreference("_AUTH_EXPIRES", 0L);

        // Init ViewModel
        splashViewModel = new SplashViewModel(this);

        // Try Loading Profile
        splashViewModel.getAccountsViewModel().accountSelf();

        // Animate Views
        animateViews();

        // Go To Login
        try {
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                try {
                    Intent intent;
                    if(isLoggedIn && !CommonConstants.AUTH_TOKEN.equals("")){
                        intent = new Intent(SplashActivity.this, DashboardActivity.class);
                    }else{
                        intent = new Intent(SplashActivity.this, LoginActivity.class);
                    }
                    intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP|FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }, 4000);
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