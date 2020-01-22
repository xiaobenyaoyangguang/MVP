package jp.co.ricoh.advop.cute.mvpsample.di.presenter.contract;


import java.util.List;

import io.reactivex.Observable;
import jp.co.ricoh.advop.cute.mvpsample.bean.BaseResult;
import jp.co.ricoh.advop.cute.mvpsample.bean.request.PostRequestBean;
import jp.co.ricoh.advop.cute.mvpsample.bean.request.PutRequestBean;
import jp.co.ricoh.advop.cute.mvpsample.bean.result.GetDataBean;
import jp.co.ricoh.advop.cute.mvpsample.bean.result.PostDataBean;


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
