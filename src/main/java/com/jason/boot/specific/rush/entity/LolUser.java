package com.jason.boot.specific.rush.entity;

import com.jason.boot.common.base.BaseBean;
/**
 * 用户类
 * @author jason
 *
 */
public class LolUser extends BaseBean{
	private static final long serialVersionUID = 1L;
	
	private String id;
	/**
	 * 登录账号
	 */
    private String loginNo;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 账户余额
     */
    private Integer account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo == null ? null : loginNo.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }
    @Override
    public String toString(){
    	return "【loginNo="+loginNo+"  nickname="+nickname+"  account="+account+"】";
    }
}