package jp.co.ricoh.advop.cute.mvpsample.data.http;

import java.io.IOException;

import io.reactivex.annotations.NonNull;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseUrlManagerInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request oldRequest = chain.request();
        HttpUrl requestUrl = oldRequest.url();
        String oldUrl = requestUrl.toString();

//        if (TextUtils.isEmpty(mOriginalBaseUrl)
//                || TextUtils.isEmpty(mNewBaseUrl)
//                || TextUtils.equals(mOriginalBaseUrl, mNewBaseUrl)
//                || !oldUrl.startsWith(mOriginalBaseUrl)) {
//            return chain.proceed(chain.request());
//        }
       if (oldUrl.startsWith(ApiService.BASE_URL)) {
           HttpUrl url = requestUrl.newBuilder().build();
           Request newRequest = oldRequest
                   .newBuilder()
                   .url(url)
                   .build();
           return chain.proceed(newRequest);
       }else {
           return chain.proceed(oldRequest);
       }

    }


}
