package com.exam.myarchitecture.model;

/**
 * Created by SuperFan on 2016/9/10.
 */
public class LoginInfo {


    /**
     * createTime : 2016-08-26 11:58:25
     * workernumber : 010
     * lastLogin : 2016-08-26 11:57:58
     * hosCode :
     * userCode : 0810
     * nickName : nick
     * state : 301
     * userPass : /QXxUyMVqIMFRlYmwVXtmZWud5AgCWUWNVKnjQTwlCw=
     * userType :
     */

    private String createTime;//创建时间
    private String workernumber;//工号，业务编码
    private String lastLogin;//最后登录的时间
    private String hosCode;
    private String userCode;//用户编码，表示用户
    private String nickName;//昵称
    private String state;//状态，字段中有描述
    private String userPass;//用户密码加密后
    private String userType;//用户类型

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getWorkernumber() {
        return workernumber;
    }

    public void setWorkernumber(String workernumber) {
        this.workernumber = workernumber;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getHosCode() {
        return hosCode;
    }

    public void setHosCode(String hosCode) {
        this.hosCode = hosCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
