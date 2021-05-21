package xyz.matirbank.app.activities.views.accounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import xyz.matirbank.app.databinding.ActivityPreLoginBinding;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class PreLoginActivity extends AppCompatActivity {

    ActivityPreLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Clear Activity Stack and Go To Login
        Intent intent = new Intent(this, PreLoginActivity.class);
        intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP|FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}