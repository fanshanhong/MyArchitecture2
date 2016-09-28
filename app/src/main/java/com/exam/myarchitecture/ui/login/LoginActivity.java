package com.exam.myarchitecture.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.exam.myarchitecture.R;
import com.exam.myarchitecture.ui.base.BaseActivity;
import com.exam.myarchitecture.utils.ToastUtil;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by SuperFan on 2016/9/9.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {
    @Bind(R.id.state_layout)
    ViewAnimator viewAnimator;
    @Bind(R.id.user_name_edit)
    EditText userNameEdit;
    @Bind(R.id.user_passward_edit)
    EditText userPasswardEdit;

    @Inject
    LoginPresenter loginPresenter;



    @Override
    protected int initContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void getIntentData(Intent intent) {

    }

    @Override
    protected void initInjector() {
        DaggerLoginComponent.builder().applicationComponent(getApplicationComponent())
                .loginModule(new LoginModule()).build().inject(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        loginPresenter.attachView(this);
    }

    @Override
    protected ViewAnimator initViewAnimator() {
        return viewAnimator;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

//    @Override
//    protected void setStatusBarColor() {
//        StatusBarUtil.setColor(this, Color.parseColor("#000066"), 128);
//    }

    @Override
    public void showLoadingView() {
        showProgressBar();
    }

    @Override
    public void hideLoadingView() {
        showNone();
    }


    @Override
    public void showToast(String text) {
        ToastUtil.showToast(this, text, Toast.LENGTH_SHORT);
    }

    @OnClick({R.id.login_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                loginPresenter.toLogin(userNameEdit.getText() != null ? userNameEdit.getText().toString():""
                        ,userPasswardEdit.getText() != null ? userPasswardEdit.getText().toString():"");
                break;
        }
    }

    @Override
    public void startToHomeActivity() {

    }

    @Override
    protected void onDestroy() {
        if(loginPresenter != null){
            loginPresenter.detachView();
        }
        super.onDestroy();
    }


}
