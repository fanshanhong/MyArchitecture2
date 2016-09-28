package com.exam.myarchitecture.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewAnimator;

import com.exam.myarchitecture.BuildConfig;
import com.exam.myarchitecture.EApplication;
import com.squareup.leakcanary.RefWatcher;

/**
 * 为子类Fragment提供一些默认的实现
 */
public abstract class BaseFragment extends Fragment {

    ViewAnimator viewAnimator;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInjector();
        getBundle(getArguments());
        initData();
        initView(view);
        viewAnimator = initViewAnimator();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(initContentView(), null);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Abstract Method In Fragment
    // 根据子类需求必须实现
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 连接器/注入器 的初始化
     */
    public abstract void initInjector();

    /**
     * 界面初始化, 这里只需要返回R.id.xx即可
     *
     * @return R.id.xx
     */
    public abstract int initContentView();

    /**
     * 得到Activity传进来的值
     */
    public abstract void getBundle(Bundle bundle);

    /**
     * 初始化控件
     */
    public abstract void initView(View view);

    /**
     * 在监听器之前把数据准备好
     */
    public abstract void initData();

    /**
     * 由子类提供包含有 Empty/Error/ProgressBar 的 ViewAnimator
     * 如果子类想要个性化Empty/Error/ProgressBar, 在xml中定制ViewAnimator, 然后将对象返回即可
     * tip:定制的xml布局, 必须遵循第一个子布局为none, 第二个子布局为loading, 第三个子布局为empty, 第四个为error
     */
    protected abstract ViewAnimator initViewAnimator();


    ///////////////////////////////////////////////////////////////////////////
    // Common Method In Fragment
    // 为子类提供ErrorView  EmptyView  ProgressView 的通用操作方法
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 隐藏progressBar/ErrorView/EmptyView
     */
    protected void showNone() {
        viewAnimator.setDisplayedChild(0);
    }

    /**
     * 为子类提供展示progressBar的通用方法
     */
    protected void showProgressBar() {
        viewAnimator.setDisplayedChild(1);
    }

    /**
     * 为子类提供展示EmptyView的通用方法
     */
    protected void showEmptyView() {
        viewAnimator.setDisplayedChild(2);
    }

    /**
     * 为子类提供展示ErrorView的通用方法
     */
    protected void showErrorView() {
        viewAnimator.setDisplayedChild(3);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Common Method In Fragment
    // 为子类提供通用的操作方法
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) {
            // 检测内存泄漏
            RefWatcher refWatcher = EApplication.getRefWatcher(getActivity());
            refWatcher.watch(this);
        }
    }
}
