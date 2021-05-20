package xyz.matirbank.app;

import android.content.Context;

public class ThisApplication extends android.app.Application {

    private static ThisApplication thisApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        thisApplication = this;
    }

    public static Context getContext() {
        return getThisApplication().getApplicationContext();
    }

    public static ThisApplication getThisApplication() {
        return thisApplication;
    }
}
