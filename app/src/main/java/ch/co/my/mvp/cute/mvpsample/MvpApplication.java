package ch.co.my.mvp.cute.mvpsample;

import android.app.Application;
import android.content.Context;

import ch.co.my.mvp.cute.mvpsample.di.component.AppComponent;
import ch.co.my.mvp.cute.mvpsample.di.component.DaggerAppComponent;
import ch.co.my.mvp.cute.mvpsample.di.module.AppModule;
import ch.co.my.mvp.cute.mvpsample.di.module.HttpModule;

public class MvpApplication extends Application {
    private static MvpApplication sManagementApplication;
    private AppComponent mAppComponent;
    public static MvpApplication get() {
        return sManagementApplication;
    }
    public static MvpApplication get(Context context) {
        return (MvpApplication) context.getApplicationContext();
    }
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sManagementApplication = this;

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule(getApplicationContext()))
                .build();
    }
}
