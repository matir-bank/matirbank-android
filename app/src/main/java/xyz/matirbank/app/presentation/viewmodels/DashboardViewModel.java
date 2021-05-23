package xyz.matirbank.app.presentation.viewmodels;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.presentation.activities.DashboardActivity;
import xyz.matirbank.app.presentation.activities.common.SplashActivity;
import xyz.matirbank.app.presentation.adapters.CardAdapter;
import xyz.matirbank.app.utils.CommonConstants;
import xyz.matirbank.app.viewmodels.AccountsViewModel;
import xyz.matirbank.app.viewmodels.CardsViewModel;

public class DashboardViewModel {

    private AccountsViewModel accountsViewModel;
    private CardsViewModel cardsViewModel;

    public DashboardViewModel(DashboardActivity activity) {
        accountsViewModel = new ViewModelProvider(activity).get(AccountsViewModel.class);
        cardsViewModel = new ViewModelProvider(activity).get(CardsViewModel.class);

        observers(activity);
    }

    private void observers(DashboardActivity activity) {
        accountsViewModel.getAccount().observe(activity, response -> {
            activity.binding.txtName.setText(response.getData().getName());
        });
        cardsViewModel.getCards().observe(activity, response -> {
            CardAdapter cardAdapter = new CardAdapter(activity, response.getData());
            activity.binding.cardRecycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
            activity.binding.cardRecycler.setAdapter(cardAdapter);
        });
    }

    public AccountsViewModel getAccountsViewModel() {
        return accountsViewModel;
    }

    public CardsViewModel getCardsViewModel() {
        return cardsViewModel;
    }
}
