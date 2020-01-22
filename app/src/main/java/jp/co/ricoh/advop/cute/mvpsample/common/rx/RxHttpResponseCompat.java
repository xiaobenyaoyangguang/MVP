package jp.co.ricoh.advop.cute.mvpsample.common.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import jp.co.ricoh.advop.cute.mvpsample.bean.BaseResult;

public class RxHttpResponseCompat {

    public static <T> ObservableTransformer<BaseResult, T> compatResult() {

        return new ObservableTransformer<BaseResult, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResult> baseResultObservable) {
                return baseResultObservable.flatMap(new Function<BaseResult, ObservableSource<T>>() {
                                                        @Override
                                                        public ObservableSource<T> apply(final BaseResult tBaseResult) {
                                                            Log.i("RxHttpResponseCompat", "apply: tBaseResult " + tBaseResult);
                                                            if (tBaseResult != null) {
                                                                //请求成功时
                                                                return Observable.create(new ObservableOnSubscribe<T>() {
                                                                    @Override
                                                                    public void subscribe(ObservableEmitter<T> emitter) {
                                                                        try {
                                                                            emitter.onNext((T) tBaseResult);
                                                                            emitter.onComplete();
                                                                        } catch (Exception e) {
                                                                            //异常时
                                                                            emitter.onError(e);
                                                                        }
                                                                    }
                                                                });
                                                            } else {
                                                                return Observable.create(new ObservableOnSubscribe<T>() {
                                                                    @Override
                                                                    public void subscribe(ObservableEmitter<T> emitter) {
                                                                        try {
                                                                            BaseResult baseResult1 = new BaseResult();
                                                                            emitter.onNext((T) baseResult1);
                                                                            emitter.onComplete();
                                                                        } catch (Exception e) {
                                                                            // exception.
                                                                            emitter.onError(e);
                                                                        }
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    }
                ).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }

}
