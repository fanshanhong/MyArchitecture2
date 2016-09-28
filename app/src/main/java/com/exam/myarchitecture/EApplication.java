package com.exam.myarchitecture;

import android.app.Application;
import android.content.Context;

import com.exam.myarchitecture.utils.StrictModeUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


/**
 * Created by fan on 2016/8/9.
 */
public class EApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        // 当前APP处于调试模式
        if (BuildConfig.DEBUG) {
            StrictModeUtil.init();// 开启严苛模式
            initLeakCanary();// 检查内存泄漏
        }

        super.onCreate();
        initInjector();
        initFresco();
    }

    /**
     * Fresco初始化
     */
    private void initFresco() {
        Fresco.initialize(this);
    }

    /**
     * 内存检测初始化
     */
    private void initLeakCanary() {
        // LeakCanary.install() 会返回一个预定义的 RefWatcher
        // 同时也会启用一个 ActivityRefWatcher，用于自动监控调用 Activity.onDestroy() 之后泄露的 activity
        refWatcher = LeakCanary.install(this);
    }

    /**
     * 获取refWatcher实例
     *
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        EApplication application = (EApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    /**
     * 连接器初始化
     */
    private void initInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }


    /**
     * 获取Component
     *
     * @return
     */
    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
