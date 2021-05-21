package xyz.matirbank.app.api.managers;

import javax.inject.Inject;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.api.interfaces.IAccounts;
import xyz.matirbank.app.services.interfaces.IRetrofitService;

public class AccountsAPI {

    @Inject
    IRetrofitService _retrofitService;

    IAccounts accounts;

    public AccountsAPI() {
        ThisApplication.getInstance().getComponents().inject(this);
        accounts = _retrofitService.getClient().create(IAccounts.class);
    }


}
