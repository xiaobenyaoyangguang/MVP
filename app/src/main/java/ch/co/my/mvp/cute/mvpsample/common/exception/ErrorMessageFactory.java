package ch.co.my.mvp.cute.mvpsample.common.exception;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import ch.co.my.mvp.cute.mvpsample.R;
import ch.co.my.mvp.cute.mvpsample.bean.result.ErrorBean;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

public class ErrorMessageFactory {

    private static String TAG = ErrorMessageFactory.class.getSimpleName();

    public static String create(Throwable e, Context context) {
        Log.i(TAG, "create = " + e.toString());
        if (e instanceof HttpException) {
            Response response = ((HttpException) e).response();
            Log.i(TAG, "response.code = " + response.code());
            if (response.code() == 400 || response.code() == 500) {
                // HttpException.
                // Exception returned by the server.
                ResponseBody body = ((HttpException) e).response().errorBody();
                try {
                    assert body != null;
                    String ss = body.string();
                    Log.i(TAG, "onError = " + ss);
                    ErrorBean errorBean = new Gson().fromJson(ss, ErrorBean.class);
                    return getErrorMsg(context, errorBean.getErrorID());
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return (context.getResources().getString(R.string.toast_fail));
                }
            } else {
                // HttpException.
                // Other exception returned by the server.
                return context.getResources().getString(R.string.toast_fail);

            }

        } else {
            // Other exception.
            return context.getResources().getString(R.string.toast_fail);
        }

    }

    private static String getErrorMsg(Context context, int errCodeId) {
        String errorMsg = null;

        switch (errCodeId) {
            case 0:
            case 1:
            case 2:
            case 5:
            case 6:
                break;
            case 3:
                break;
            default:
                Log.e(TAG, "getErrorMsg: unknown error code");
                break;
        }

        return errorMsg;
    }
}
