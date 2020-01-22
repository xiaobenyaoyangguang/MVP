package ch.co.my.mvp.cute.mvpsample.common.rx.observer;
import io.reactivex.Observer;
import ch.co.my.mvp.cute.mvpsample.bean.BaseResult;

public interface BaseObserver<T> extends Observer<T> {
    void onNext(BaseResult<T> value);
}
