package jp.co.ricoh.advop.cute.mvpsample.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.co.ricoh.advop.cute.mvpsample.MvpApplication;
import jp.co.ricoh.advop.cute.mvpsample.di.component.AppComponent;
import jp.co.ricoh.advop.cute.mvpsample.di.presenter.BasePresenter;


public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private Unbinder mUnbinder;

    private MvpApplication mApplication;

    @Inject
    T mPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);

        mApplication = (MvpApplication) getApplication();
        setupActivityComponent(mApplication.getAppComponent());
        init();
    }

    public abstract int setLayout();
    public abstract void setupActivityComponent(AppComponent appComponent);
    public abstract void init();


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mUnbinder != Unbinder.EMPTY){

            mUnbinder.unbind();
        }
    }
}
