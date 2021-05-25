package xyz.matirbank.app.presentation.activities.accounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.entities.accounts.requests.RegisterRequest;
import xyz.matirbank.app.databinding.ActivityRegisterBinding;
import xyz.matirbank.app.presentation.viewmodels.RegisterViewModel;
import xyz.matirbank.app.utils.CommonUtils;

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
            requestRegister();
        });

        binding.txtLogin.setOnClickListener(v -> {
            gotoLogin();
        });

        binding.editType.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus) {
                CommonUtils.hideKeyboard(RegisterActivity.this);
            }
        });

        String[] accountTypes = {"Personal", "Agent", "Merchant"};
        ArrayAdapter<String> accountTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, accountTypes);
        binding.editType.setAdapter(accountTypeAdapter);

    }

    void requestRegister() {

        String phone = binding.editPhone.getText().toString();
        String password = binding.editPassword.getText().toString();
        String confirmPassword = binding.editPasswordConfirm.getText().toString();
        String name = binding.editName.getText().toString();
        String type = binding.editType.getAdapter().getItem(binding.editType.getListSelection()).toString();

        if(!password.equals(confirmPassword)){
            Toast.makeText(this, "Password Does Not Match", Toast.LENGTH_SHORT).show();
            return;
        }

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(name);
        registerRequest.setPhone(phone);
        registerRequest.setPassword(password);
        registerRequest.setType(type);

        registerViewModel.getAccountsViewModel().accountsRegister(registerRequest);
        showLoading();

    }

    void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP|FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    public void showLoading() {
        binding.layoutLoading.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        binding.layoutLoading.setVisibility(View.GONE);
    }
}