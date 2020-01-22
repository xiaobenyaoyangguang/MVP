package ch.co.my.mvp.cute.mvpsample.di.presenter.contract;


import io.reactivex.Observable;
import ch.co.my.mvp.cute.mvpsample.bean.BaseResult;
import ch.co.my.mvp.cute.mvpsample.bean.request.PostRequestBean;
import ch.co.my.mvp.cute.mvpsample.bean.request.PutRequestBean;
import ch.co.my.mvp.cute.mvpsample.bean.result.GetDataBean;
import ch.co.my.mvp.cute.mvpsample.bean.result.PostDataBean;


public interface HomeContract {
    public interface IHomeModel {
        Observable<GetDataBean> getData(String url);
        Observable<PostDataBean> postData(String url, PostRequestBean postRequestBean);
        Observable<BaseResult> putData(String url, String authorization, PutRequestBean bean);
        Observable<BaseResult> deleteData(String url,String authorization);


    }

    public interface HomeView {
        void showSuccess();
        void showFailed(String errorReason);

    }
}
