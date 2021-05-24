package xyz.matirbank.app.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import xyz.matirbank.app.databinding.ActivityDashboardBinding;
import xyz.matirbank.app.presentation.viewmodels.DashboardViewModel;

public class DashboardActivity extends AppCompatActivity {

    DashboardViewModel dashboardViewModel;
    public ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dashboardViewModel = new DashboardViewModel(this);
        initViews();

        dashboardViewModel.getAccountsViewModel().account();
        dashboardViewModel.getCardsViewModel().cards();
    }

    void initViews() {

    }
}