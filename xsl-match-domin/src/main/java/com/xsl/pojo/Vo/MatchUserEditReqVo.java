package com.xsl.pojo.Vo;

import java.io.Serializable;

/**
 * 说明：更改用户信息Vo
 *
 * @Auther: 11432_000
 * @Date: 2019/5/8 17:33
 * @Description:
 */
public class MatchUserEditReqVo implements Serializable {

    private String userid;

    private String name;

    private String email;

    private String signature;

    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
