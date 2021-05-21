package xyz.matirbank.app.presentation.activities.accounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.accounts.requests.Login;
import xyz.matirbank.app.api.entities.accounts.requests.Register;
import xyz.matirbank.app.databinding.ActivityRegisterBinding;
import xyz.matirbank.app.presentation.viewmodels.RegisterViewModel;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class RegisterActivity extends AppCompatActivity {

    RegisterViewModel registerViewModel;
    public ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThisApplication.getInstance().getComponents().inject(this);

        registerViewModel = new RegisterViewModel(this);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();

    }

    void initViews() {

        binding.btnRegister.setOnClickListener(v -> {
            String phone = binding.editPhone.getText().toString();
            String password = binding.editPassword.getText().toString();
            String name = binding.editName.getText().toString();
            String type = binding.editType.getAdapter().getItem(binding.editType.getListSelection()).toString();

            Register register = new Register();
            register.setName(name);
            register.setPhone(phone);
            register.setPassword(password);
            register.setType(type);

            registerViewModel.getAccountsViewModel().accountsRegister(register);
        });

        binding.txtLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP|FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(0,0);
        });
    }
}