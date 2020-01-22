package jp.co.ricoh.advop.cute.mvpsample.di.presenter;

import android.app.Fragment;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;


public class BasePresenter<M, V> {

    protected M mModel;

    protected V mView;

    protected Context mContext;

    public BasePresenter(M m, V v) {

        this.mModel = m;
        this.mView = v;
        initContext();

    }

    private void initContext() {

        if (mView instanceof Fragment) {
            mContext = ((Fragment) mView).getActivity();
        } else {
            mContext = (AppCompatActivity) mView;
        }
    }
}
