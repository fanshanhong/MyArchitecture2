package com.exam.myarchitecture.contants;

/**
 * Created by SuperFan on 2016/9/8.
 */
public class ServerConstant {

    //服务访问设置
    public static boolean ISHTTPS = false;//是否是https服务
    public static final int DEFAULT_TIMEOUT = 5;//连接服务的超时时间（秒）

    //访问服务器成功的标志
    public static String SERVER_SUCCESS_RESULT_TYPE = "success";

    // Cookie失效的code
    public static String COOKIE_INVALID_CODE = "";

    //访问服务器失败后的提示
    public static String ACCESS_SERVER_FAILURE = "访问服务器失败..";
    //手机类型标识符
    public static String PHONE_TYPE = "01";



    // 服务器路径
    public static final String SERVER_PATH = "server_path";


    // 登录路径
    public static final String LOGIN_PATH = "login_path";
    // 登录的参数
    public static final String USER_NAME_KEY = "user_name";
    public static final String USER_PWD_KEY = "password";

}
