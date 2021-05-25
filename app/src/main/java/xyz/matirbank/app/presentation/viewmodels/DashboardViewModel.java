package xyz.matirbank.app.presentation.viewmodels;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.presentation.activities.common.DashboardActivity;
import xyz.matirbank.app.presentation.adapters.CardAdapter;
import xyz.matirbank.app.viewmodels.AccountsViewModel;
import xyz.matirbank.app.viewmodels.CardsViewModel;

public class DashboardViewModel {

    private final AccountsViewModel accountsViewModel;
    private final CardsViewModel cardsViewModel;

    public DashboardViewModel(DashboardActivity activity) {
        // Init Dagger
        ThisApplication.getInstance().getComponents().inject(this);

        // Init View Models
        accountsViewModel = new ViewModelProvider(activity).get(AccountsViewModel.class);
        cardsViewModel = new ViewModelProvider(activity).get(CardsViewModel.class);

        // Init Observer
        observers(activity);
    }

    private void observers(DashboardActivity activity) {

        accountsViewModel.getAccountSelf().observe(activity, response -> {
            if(response != null) {
                if(response.getData() != null) {
                    activity.binding.txtName.setText(response.getData().getName());
                    if(response.getData().getCards() != null) {
                        CardAdapter cardAdapter = new CardAdapter(activity, response.getData().getCards());
                        activity.binding.cardRecycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
                        activity.binding.cardRecycler.setAdapter(cardAdapter);
                    }
                }
            }
        });

        cardsViewModel.getCards().observe(activity, response -> {
            if(response != null) {
                if(response.getData() != null) {
                    //
                }
            }
        });

    }

    public AccountsViewModel getAccountsViewModel() {
        return accountsViewModel;
    }

    public CardsViewModel getCardsViewModel() {
        return cardsViewModel;
    }
}
