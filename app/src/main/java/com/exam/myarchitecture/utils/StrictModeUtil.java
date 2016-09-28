package com.exam.myarchitecture.utils;

import android.os.Build;
import android.os.StrictMode;

/**
 * 开启严格模式，检测内存、硬盘等敏感操作，线程监控出现问题会出对话框提示
 * Created by zhaokaiqiang on 15/11/9.
 */
public class StrictModeUtil {

    public static void init() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.FROYO) {

            //线程监控，会弹框哦
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
//                    .penaltyDialog()// 不要弹框
                    .build());

            //VM监控
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
    }

}
