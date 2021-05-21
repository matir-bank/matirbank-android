package xyz.matirbank.app.activities.views.accounts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.databinding.ActivityLoginBinding;
import xyz.matirbank.app.services.interfaces.IAccountServices;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Inject
    IAccountServices _accountServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ThisApplication.getInstance().getComponents().inject(this);
    }
}