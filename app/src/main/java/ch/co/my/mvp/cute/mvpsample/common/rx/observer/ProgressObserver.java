package ch.co.my.mvp.cute.mvpsample.common.rx.observer;

import android.content.Context;
import android.util.Log;

import io.reactivex.disposables.Disposable;
import ch.co.my.mvp.cute.mvpsample.R;
import ch.co.my.mvp.cute.mvpsample.dialog.HttpProgressDialog;


public abstract class ProgressObserver<T> implements BaseObserver<T> {
    private static final String TAG = ProgressObserver.class.getSimpleName();
    private Context mContext;
    private HttpProgressDialog progressDialog;
    private boolean isShowProgress = false;

    protected ProgressObserver(Context context) {
        this.mContext = context.getApplicationContext();
        this.isShowProgress = false;
    }

    protected ProgressObserver(Context context, boolean isShowProgress) {
        this.mContext = context.getApplicationContext();
        this.isShowProgress = isShowProgress;
        if (isShowProgress) {
            progressDialog = new HttpProgressDialog(context, R.style.progress_dialog);
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.i(TAG, "onSubscribe >> ______");
        Log.i(TAG, "onSubscribe >> Disposable: " + d.toString());
        if (isShowProgress) {
            progressDialog.show();
        }
    }

    @Override
    public void onNext(T t) {
        Log.i(TAG, "onNext >> ______");
        Log.i(TAG, "onNext >> T: " + t.toString());
        onHandleSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        Log.i(TAG, "onError >> ______");
        Log.i(TAG, "onError >> e: " + e.toString());
        if (isShowProgress) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
        onHandleError(e);
    }

    @Override
    public void onComplete() {
        Log.i(TAG, "onComplete >> ______");
        if (isShowProgress) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    protected abstract void onHandleSuccess(T t);

    protected abstract void onHandleError(Throwable e);

}
