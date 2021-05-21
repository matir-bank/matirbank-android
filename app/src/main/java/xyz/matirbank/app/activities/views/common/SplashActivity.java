package xyz.matirbank.app.activities.views.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.activities.viewmodels.SplashViewModel;
import xyz.matirbank.app.databinding.ActivitySplashBinding;
import xyz.matirbank.app.services.interfaces.IAccountServices;
import xyz.matirbank.app.viewmodels.AccountsViewModel;

public class SplashActivity extends AppCompatActivity {

    SplashViewModel splashViewModel;
    public ActivitySplashBinding binding;

    @Inject
    IAccountServices _accountServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init Dagger
        ThisApplication.getInstance().getComponents().inject(this);

        // Init ViewModel
        splashViewModel = new SplashViewModel(this);

        splashViewModel.getAccountsViewModel().account();
        splashViewModel.getAccountsViewModel().accountsLogout();


        // Request Full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Bind View
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Animate Views
        animateViews();
    }

    void animateViews() {
        ObjectAnimator.ofFloat(binding.imgIcon, "alpha", 0, 1).setDuration(1200).start();
        ObjectAnimator.ofFloat(binding.txMatirBank, "translationX", 500, 0).setDuration(1000).start();
        ObjectAnimator.ofFloat(binding.txMobileFinancialService, "translationX", -500, 0).setDuration(1000).start();
    }
}