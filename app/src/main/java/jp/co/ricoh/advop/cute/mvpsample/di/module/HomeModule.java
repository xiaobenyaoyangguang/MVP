package jp.co.ricoh.advop.cute.mvpsample.di.module;

import dagger.Module;
import dagger.Provides;
import jp.co.ricoh.advop.cute.mvpsample.data.http.ApiService;
import jp.co.ricoh.advop.cute.mvpsample.data.model.HomeModel;
import jp.co.ricoh.advop.cute.mvpsample.di.presenter.contract.HomeContract;

@Module
public class HomeModule {
    private HomeContract.HomeView mView;

    public HomeModule(HomeContract.HomeView view){
        this.mView = view;
    }

    @Provides
    public HomeContract.HomeView provideView(){
        return mView;
    }

    @Provides
    public HomeContract.IHomeModel provideModel(ApiService apiService){

        return new HomeModel(apiService);
    }
}
