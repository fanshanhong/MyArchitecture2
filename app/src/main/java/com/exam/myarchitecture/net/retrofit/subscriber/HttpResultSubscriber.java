package com.exam.myarchitecture.net.retrofit.subscriber;

import com.exam.myarchitecture.contants.ServerConstant;
import com.orhanobut.logger.Logger;

import rx.Subscriber;

/**
 * Created by _SOLID
 * Date:2016/7/27
 * Time:21:27
 */
public abstract class HttpResultSubscriber<T> extends Subscriber<T> {

    private String resultMessage;
    private String resultCode;
    private String resultType;

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Logger.e(e.getMessage());
        e.printStackTrace();
        onFailure(ServerConstant.ACCESS_SERVER_FAILURE);
    }

    @Override
    public void onNext(T t) {
        if (resultCode.equals(ServerConstant.COOKIE_INVALID_CODE)) {
            onCookieInvalid(resultMessage);
        } else if(resultType.equals(ServerConstant.SERVER_SUCCESS_RESULT_TYPE)) {
            onSuccess(t);
        } else {
            onFailure(resultMessage);
        }

    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public abstract void onSuccess(T resultData);

    public abstract void onFailure(String errMessage);

    public abstract void onCookieInvalid(String errMessage);
}
