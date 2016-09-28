package com.exam.myarchitecture.ui.login;


import com.exam.myarchitecture.ui.base.BasePresenter;
import com.exam.myarchitecture.ui.base.BaseView;

/**
 * Created by fan on 2016/8/10.
 * 登录页面的契约类
 */
public interface LoginContract {

    interface View extends BaseView {
        // 这里是P层通知View层更新界面的一些回调接口
        void startToHomeActivity();

    }

    interface Presenter extends BasePresenter<View> {
        // 这里是View层调用P层的接口方法

        void toLogin(String username, String password);

    }
}
