package xyz.matirbank.app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import xyz.matirbank.app.activities.views.accounts.PreLoginActivity;
import xyz.matirbank.app.services.RetrofitService;
import xyz.matirbank.app.ioc.DaggerModuleComponents;
import xyz.matirbank.app.ioc.ModuleComponents;
import xyz.matirbank.app.ioc.Modules;
import zerobranch.androidremotedebugger.AndroidRemoteDebugger;

public class ThisApplication extends android.app.Application {

    private static ThisApplication thisApplication;
    private ModuleComponents moduleComponents;
    public static boolean loginRedirect = false;

    @Override
    public void onCreate() {
        super.onCreate();
        thisApplication = this;
        moduleComponents = DaggerModuleComponents.builder().modules(new Modules()).build();

        if (BuildConfig.DEBUG) {
            AndroidRemoteDebugger.init(new AndroidRemoteDebugger.Builder(getContext()).port(8070).build());
        }
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

    public static void gotoLogin() {
        if(!loginRedirect){return;}
        Intent intent = new Intent(getContext(), PreLoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }
}
