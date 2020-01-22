package jp.co.ricoh.advop.cute.mvpsample.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.ricoh.advop.cute.mvpsample.data.http.ApiService;
import jp.co.ricoh.advop.cute.mvpsample.di.module.AppModule;
import jp.co.ricoh.advop.cute.mvpsample.di.module.HttpModule;


@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public Application getApplication(Application application);
    public ApiService getApiService();
}
