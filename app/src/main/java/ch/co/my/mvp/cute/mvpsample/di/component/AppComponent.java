package ch.co.my.mvp.cute.mvpsample.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import ch.co.my.mvp.cute.mvpsample.data.http.ApiService;
import ch.co.my.mvp.cute.mvpsample.di.module.AppModule;
import ch.co.my.mvp.cute.mvpsample.di.module.HttpModule;


@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public Application getApplication(Application application);
    public ApiService getApiService();
}
