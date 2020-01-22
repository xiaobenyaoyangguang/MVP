package jp.co.ricoh.advop.cute.mvpsample.data.http;

import io.reactivex.Observable;
import jp.co.ricoh.advop.cute.mvpsample.bean.BaseResult;
import jp.co.ricoh.advop.cute.mvpsample.bean.request.PostRequestBean;
import jp.co.ricoh.advop.cute.mvpsample.bean.request.PutRequestBean;
import jp.co.ricoh.advop.cute.mvpsample.bean.result.GetDataBean;
import jp.co.ricoh.advop.cute.mvpsample.bean.result.PostDataBean;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface ApiService {
    // Base URl
    public String BASE_URL = "http://192.168.1.1";


    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET
    public Observable<GetDataBean> getData(@Url String url);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST
    public Observable<PostDataBean> postData(@Url String url, @Body PostRequestBean bean);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @PUT
    public Observable<BaseResult> putData(@Url String url,
                                              @Header("Authorization")String authorization,
                                              @Body PutRequestBean bean);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @DELETE
    public Observable<BaseResult> deleteData(@Url String url,
                                              @Header("Authorization")String authorization);

}
