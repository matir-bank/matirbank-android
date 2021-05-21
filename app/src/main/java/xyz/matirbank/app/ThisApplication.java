package xyz.matirbank.app;

import android.content.Context;
import android.content.Intent;

import xyz.matirbank.app.activities.views.accounts.PreLoginActivity;
import xyz.matirbank.app.services.RetrofitService;
import xyz.matirbank.app.ioc.DaggerModuleComponents;
import xyz.matirbank.app.ioc.ModuleComponents;
import xyz.matirbank.app.ioc.Modules;

public class ThisApplication extends android.app.Application {

    private static ThisApplication thisApplication;
    private ModuleComponents moduleComponents;

    @Override
    public void onCreate() {
        super.onCreate();
        thisApplication = this;
        RetrofitService.init();
        moduleComponents = DaggerModuleComponents.builder().modules(new Modules()).build();
    }

    public static Context getContext() {
        return getInstance().getApplicationContext();
    }

    public static ThisApplication getInstance() {
        return thisApplication;
    }

    public ModuleComponents getComponents() {
        return this.moduleComponents;
    }

    public static boolean loginRedirect = false;
    public static void gotoLogin() {
        if(!loginRedirect){return;}
        Intent intent = new Intent(getContext(), PreLoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }
}
