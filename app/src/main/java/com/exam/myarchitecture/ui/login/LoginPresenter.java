package com.exam.myarchitecture.ui.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.exam.myarchitecture.R;
import com.exam.myarchitecture.contants.ServerConstant;
import com.exam.myarchitecture.model.LoginInfo;
import com.exam.myarchitecture.net.retrofit.service.RxBaseApi;
import com.exam.myarchitecture.net.retrofit.subscriber.HttpResultSubscriber;
import com.exam.myarchitecture.utils.AccountUtil;
import com.exam.myarchitecture.utils.NetWorkUtil;
import com.exam.myarchitecture.utils.ServerUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.Subscription;

/**
 *
 * LoginActivity对应的Presenter
 */
public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View mLoginView;
    private Context mContext;

    private String host;

    private Subscription subscription;
    private String loginSuccessMessage;//登录成功的服务提示信息

    @Inject
    public LoginPresenter(Context context){
        this.mContext = context;
        host = ServerUtil.getServerHost(mContext);
    }


    @Override
    public void attachView(@NonNull LoginContract.View view) {
        this.mLoginView = view;
    }

    @Override
    public void detachView() {
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }

        mLoginView = null;
    }


    /**
     * 调用Model层, 进行登录
     * @param username
     * @param password
     */
    @Override
    public void toLogin(@NonNull String username, @NonNull String password) {

        //参数判断
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(username.trim())){
            mLoginView.showToast("请填写用户名");
            return;
        }
        if(TextUtils.isEmpty(password) || TextUtils.isEmpty(password.trim())){
            mLoginView.showToast("请填写密码");
            return;
        }

        if(TextUtils.isEmpty(host)){
            mLoginView.showToast(mContext.getString(R.string.emdt_host_empty));
            return;
        }
        if(!NetWorkUtil.isNetWorkConnected(mContext)){
            mLoginView.showToast(mContext.getString(R.string.please_check_network_connection));
            return;
        }

        // 登录请求用户信息
        Map<String,String> param = new HashMap<>();
        param.put(ServerConstant.USER_NAME_KEY,username);
        param.put(ServerConstant.USER_PWD_KEY, password);
        subscription = RxBaseApi.getDefault(mContext, host + ServerConstant.SERVER_PATH, null)
                .executePost(mContext, new LoginResultSubscriber(),LoginInfo.class,ServerConstant.LOGIN_PATH, param);

    }

    /**
     * 访问登录服务后的回调
     */
    private class LoginResultSubscriber extends HttpResultSubscriber<LoginInfo> {

        /**
         * 这个是Rxjava 中订阅发生之前执行的方法，可以初始化一些参数等
         */
        @Override
        public void onStart() {
            mLoginView.showLoadingView();
        }


        @Override
        public void onFailure(String errMessage) {
            mLoginView.showToast(errMessage);
            mLoginView.hideLoadingView();
        }

        @Override
        public void onCookieInvalid(String errMessage) {
            //TODO: handle cookie invalid

        }

        @Override
        public void onSuccess(LoginInfo resultData) {

            if(resultData != null){
                loginSuccessMessage = getResultMessage();
                // Toast show the loginSuccessMessage
                AccountUtil.setUserCode(mContext, resultData.getUserCode());
                AccountUtil.setUserType(mContext, resultData.getUserType());
                AccountUtil.setUserWorkerNum(mContext, resultData.getWorkernumber());
                AccountUtil.setUserNickName(mContext, resultData.getNickName());
                AccountUtil.setUserPassward(mContext, resultData.getUserPass());
                AccountUtil.setUserState(mContext, resultData.getState());
                AccountUtil.setCreateTime(mContext, resultData.getCreateTime());
                AccountUtil.setLastLoginTime(mContext, resultData.getLastLogin());

            }else{
                mLoginView.showToast("登录失败");
                mLoginView.hideLoadingView();
            }
        }
    }
}
