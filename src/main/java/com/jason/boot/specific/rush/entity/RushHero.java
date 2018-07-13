package com.jason.boot.specific.rush.entity;

import java.util.Date;

import com.jason.boot.common.base.BaseBean;
/**
 * 半价折扣的英雄
 * @author jason
 *
 */
public class RushHero extends BaseBean {
	private static final long serialVersionUID = 1L;

	private String id;
	/**
	 * 英雄名
	 */
    private String heroName;
    /**
     * 促销价
     */
    private Integer rushPrice;
    /**
     * 促销开始时间
     */
    private Date startTime;
    /**
     * 促销结束时间
     */
    private Date endTime;
    /**
     * 促销剩余数量
     */
    private Integer surplus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName == null ? null : heroName.trim();
    }

    public Integer getRushPrice() {
        return rushPrice;
    }

    public void setRushPrice(Integer rushPrice) {
        this.rushPrice = rushPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

	public Integer getSurplus() {
		return surplus;
	}

	public void setSurplus(Integer surplus) {
		this.surplus = surplus;
	}
}