package ch.co.my.mvp.cute.mvpsample.data.model;


import io.reactivex.Observable;
import ch.co.my.mvp.cute.mvpsample.bean.BaseResult;
import ch.co.my.mvp.cute.mvpsample.bean.request.PostRequestBean;
import ch.co.my.mvp.cute.mvpsample.bean.request.PutRequestBean;
import ch.co.my.mvp.cute.mvpsample.bean.result.GetDataBean;
import ch.co.my.mvp.cute.mvpsample.bean.result.PostDataBean;
import ch.co.my.mvp.cute.mvpsample.data.http.ApiService;
import ch.co.my.mvp.cute.mvpsample.di.presenter.contract.HomeContract;


public class HomeModel implements HomeContract.IHomeModel{

    private ApiService mApiService;

    public HomeModel(ApiService apiService){
        this.mApiService = apiService;
    }


    @Override
    public Observable<GetDataBean> getData(String url) {
        return mApiService.getData(url);
    }

    @Override
    public Observable<PostDataBean> postData(String url, PostRequestBean postRequestBean) {
        return mApiService.postData(url, postRequestBean);
    }

    @Override
    public Observable<BaseResult> putData(String url, String authorization, PutRequestBean bean) {
        return mApiService.putData(url, authorization, bean);
    }

    @Override
    public Observable<BaseResult> deleteData(String url,String authorization) {
        return mApiService.deleteData(url,authorization);
    }
}
