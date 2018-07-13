package com.jason.boot.specific.rush.entity;

import com.jason.boot.common.base.BaseBean;
/**
 * 用户资产类（用户已拥有的英雄）
 * @author jason
 *
 */
public class UserAsset extends BaseBean {
	private static final long serialVersionUID = 1L;

	private String id;

    private String loginNo;

    private String heroName;

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

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName == null ? null : heroName.trim();
    }
}