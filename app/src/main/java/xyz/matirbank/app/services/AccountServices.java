package xyz.matirbank.app.services;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.services.interfaces.IAccountServices;

public class AccountServices implements IAccountServices {

    public AccountServices() {
        ThisApplication.getInstance().getComponents().inject(this);
    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }
}
