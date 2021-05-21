package xyz.matirbank.app.presentation.activities.accounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import javax.inject.Inject;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.databinding.ActivityLoginBinding;
import xyz.matirbank.app.presentation.viewmodels.LoginViewModel;
import xyz.matirbank.app.services.interfaces.ISharedPreference;

public class LoginActivity extends AppCompatActivity {

    public ActivityLoginBinding binding;
    LoginViewModel loginViewModel;

    @Inject
    ISharedPreference _sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThisApplication.getInstance().getComponents().inject(this);
        loginViewModel = new LoginViewModel(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
    }

    void initViews() {

        // Login Request
        binding.btnLogin.setOnClickListener(v -> {
            String phone = binding.editPhone.getText().toString();
            String password = binding.editPassword.getText().toString();

            Login login = new Login();
            login.setPhone(phone);
            login.setPassword(password);

            loginViewModel.getAccountsViewModel().accountsLogin(login);
        });

        // Detect Enter Key
        binding.editPassword.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                binding.btnLogin.performClick();
                return true;
            }
            return false;
        });

        binding.txtRegister.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            overridePendingTransition(0,0);
        });

    }
}