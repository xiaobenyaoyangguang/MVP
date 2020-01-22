package ch.co.my.mvp.cute.mvpsample.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ch.co.my.mvp.cute.mvpsample.data.http.ApiService;
import ch.co.my.mvp.cute.mvpsample.data.http.BaseUrlManagerInterceptor;
import ch.co.my.mvp.cute.mvpsample.data.http.NullOnEmptyConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    private Context mContext;

    public HttpModule(Context context){
        this.mContext = context;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // log interceptor.
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // Change the level at which this interceptor logs.
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return builder
                .addInterceptor(logging)
                // Set the time of connection timeout.
                .connectTimeout(10000, TimeUnit.SECONDS)
                // Set the read time-out.
                .readTimeout(10000, TimeUnit.SECONDS)
                .addInterceptor(new BaseUrlManagerInterceptor())
                .build();

    }


    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);


        return builder.build();

    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit) {

        return retrofit.create(ApiService.class);
    }

}
