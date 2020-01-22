package jp.co.ricoh.advop.cute.mvpsample.dialog;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

import jp.co.ricoh.advop.cute.mvpsample.R;


public class HttpProgressDialog extends ProgressDialog {

    private TextView mMessage;

    public HttpProgressDialog(Context context) {
        super(context);
    }

    public HttpProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init(getContext());
    }

    private void init(Context context) {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_http_progress);
        WindowManager.LayoutParams params = Objects.requireNonNull(getWindow()).getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);

        mMessage = this.findViewById(R.id.tv_loading_content);
    }

    @Override
    public void show() {
        super.show();
    }

    // default 'mMessage' is gone.
    public TextView getContentView(){
        return mMessage;
    }

    public void setMessage(String msg){
        mMessage.setText(msg);
    }

    public void setMessage(int stringId){
        mMessage.setText(getContext().getResources().getString(stringId));
    }
}

