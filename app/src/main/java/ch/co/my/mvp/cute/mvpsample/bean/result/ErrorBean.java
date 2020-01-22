package ch.co.my.mvp.cute.mvpsample.bean.result;


import ch.co.my.mvp.cute.mvpsample.bean.BaseResult;

public class ErrorBean extends BaseResult {


    private int errorID;
    private String message;

    public int getErrorID() {
        return errorID;
    }

    public void setErrorID(int errorID) {
        this.errorID = errorID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
