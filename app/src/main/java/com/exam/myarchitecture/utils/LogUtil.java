package com.exam.myarchitecture.utils;

import com.exam.myarchitecture.BuildConfig;
import com.orhanobut.logger.Logger;


/**
 * Created by fan on 2016/9/23.
 * <p>
 * 对Logger的进一步封装
 */
public class LogUtil {

    public static void i(String message, Object... args) {
        if (BuildConfig.LOG_DEBUG) {
            Logger.i(message, args);
        }
    }

    public static void d(String message, Object... args) {
        if (BuildConfig.LOG_DEBUG) {
            Logger.d(message, args);
        }
    }

    public static void e(String message, Object... args) {
        if (BuildConfig.LOG_DEBUG) {
            Logger.e(message, args);
        }
    }

    public static void v(String message, Object... args) {
        if (BuildConfig.LOG_DEBUG) {
            Logger.v(message, args);
        }
    }

    public static void w(String message, Object... args) {
        if (BuildConfig.LOG_DEBUG) {
            Logger.w(message, args);
        }
    }

    public static void xml(String xml) {
        if (BuildConfig.LOG_DEBUG) {
            Logger.xml(xml);
        }
    }

    public static void json(String json) {
        if (BuildConfig.LOG_DEBUG) {
            Logger.json(json);
        }
    }

}
