package xyz.matirbank.app.activities.views.common;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.services.interfaces.IAccountServices;

public class SplashActivity extends AppCompatActivity {

    xyz.matirbank.app.databinding.ActivitySplashBinding binding;

    @Inject
    IAccountServices _accountServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThisApplication.getInstance().getComponents().inject(this);

        // Request Full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Bind View
        binding = xyz.matirbank.app.databinding.ActivitySplashBinding.inflate(getLayoutInflater());
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