package com.exam.myarchitecture.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.exam.myarchitecture.contants.Constant;


/**
 * Created by fan on 2016/8/12.
 */
public class AccountUtil {

    private static final String USER_CODE = "user_code";//用户的code
    private static final String WORKER_NUMBER = "worker_number";//用户的工号
    private static final String USER_TYPE = "user_type";//用户的类型
    private static final String USER_PASS = "user_passward";//用户的加密登录密码
    private static final String NICK_NAME = "user_nick_name";//用户的昵称
    private static final String USER_STATE = "user_state";//用户的状态

    private static final String CREATE_TIME = "create_time";//创建时间
    private static final String LAST_LOGIN_TIME = "last_login_time";//最后登录时间

    /**
     * 将用户code存在SharedPreference中
     */
    public static void setUserCode(Context context, String userCode) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(USER_CODE, userCode).apply();
    }
    /**
     * 从SharedPreference中获取用户code
     *
     * @param context
     * @return 如果没有, 则返回""
     */
    public static String getUserCode(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(USER_CODE, "");
    }

    /**
     * 将用户工号存在SharedPreference中
     */
    public static void setUserWorkerNum(Context context, String workerNum) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(WORKER_NUMBER, workerNum).apply();
    }
    /**
     * 从SharedPreference中获取用户工号
     *
     * @param context
     * @return 如果没有, 则返回""
     */
    public static String getUserWorkerNum(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(WORKER_NUMBER, "");
    }

    /**
     * 将用户类型存在SharedPreference中
     */
    public static void setUserType(Context context, String userType) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(USER_TYPE, userType).apply();
    }
    /**
     * 从SharedPreference中获取用户类型
     *
     * @param context
     * @return 如果没有, 则返回""
     */
    public static String getUserType(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(USER_TYPE, "");
    }

    /**
     * 将用户加密密码存在SharedPreference中
     */
    public static void setUserPassward(Context context, String userPassward) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(USER_PASS, userPassward).apply();
    }
    /**
     * 从SharedPreference中获取用户加密密码
     *
     * @param context
     * @return 如果没有, 则返回""
     */
    public static String getUserPassward(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(USER_PASS, "");
    }

    /**
     * 将用户昵称存在SharedPreference中
     */
    public static void setUserNickName(Context context, String userNickName) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(NICK_NAME, userNickName).apply();
    }
    /**
     * 从SharedPreference中获取用户昵称
     *
     * @param context
     * @return 如果没有, 则返回""
     */
    public static String getUserNickName(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(NICK_NAME, "");
    }

    /**
     * 将用户状态存在SharedPreference中
     */
    public static void setUserState(Context context, String userState) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(USER_STATE, userState).apply();
    }
    /**
     * 从SharedPreference中获取用户状态
     *
     * @param context
     * @return 如果没有, 则返回""
     */
    public static String getUserState(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(USER_STATE, "");
    }

    /**
     * 将用户创建时间存在SharedPreference中
     */
    public static void setCreateTime(Context context, String createTime) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(CREATE_TIME, createTime).apply();
    }
    /**
     * 从SharedPreference中获取用户创建时间
     *
     * @param context
     * @return 如果没有, 则返回""
     */
    public static String getCreateTime(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(CREATE_TIME, "");
    }
    /**
     * 将用户最后登录时间存在SharedPreference中
     */
    public static void setLastLoginTime(Context context, String lastLoginTime) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(LAST_LOGIN_TIME, lastLoginTime).apply();
    }
    /**
     * 从SharedPreference中获取用户最后登录时间
     *
     * @param context
     * @return 如果没有, 则返回""
     */
    public static String getLastLoginTime(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(LAST_LOGIN_TIME, "");
    }

}
