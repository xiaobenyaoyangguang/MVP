package ch.co.my.mvp.cute.mvpsample.di.presenter;

import android.util.Log;

import ch.co.my.mvp.cute.mvpsample.bean.BaseResult;
import ch.co.my.mvp.cute.mvpsample.common.exception.ErrorMessageFactory;
import ch.co.my.mvp.cute.mvpsample.common.rx.RxHttpResponseCompat;
import ch.co.my.mvp.cute.mvpsample.common.rx.observer.ProgressObserver;
import ch.co.my.mvp.cute.mvpsample.di.presenter.contract.HomeContract;

public class HomePresenter  extends BasePresenter<HomeContract.IHomeModel, HomeContract.HomeView>{
    private static final String TAG = HomePresenter.class.getSimpleName();
    public HomePresenter(HomeContract.IHomeModel iHomeModel, HomeContract.HomeView homeView) {
        super(iHomeModel, homeView);
    }

    public void getData() {
        String url = "";
        mModel.getData(url)
                .compose(RxHttpResponseCompat.<BaseResult>compatResult())
                .subscribe(new ProgressObserver<BaseResult>(mContext) {
                    @Override
                    protected void onHandleSuccess(BaseResult baseResult1) {
                        Log.i(TAG, "getIssues >> onNext");
                        mView.showSuccess();
                    }

                    @Override
                    protected void onHandleError(Throwable e) {
                        Log.i(TAG, "onHandleError: e " + e.getMessage());
                        mView.showFailed(ErrorMessageFactory.create(e, mContext));
                    }
                });

    }
}
