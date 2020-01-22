package jp.co.ricoh.advop.cute.mvpsample.common.rx.observer;
import io.reactivex.Observer;
import jp.co.ricoh.advop.cute.mvpsample.bean.BaseResult;

public interface BaseObserver<T> extends Observer<T> {
    void onNext(BaseResult<T> value);
}
