package com.jason.boot.specific.rush.entity;
/**
 * 枚举类型，标记抢购的返回状态
 * @author jason
 *
 */
public enum RushStatEnum {
	/**
	 * SUCCESS
	 */
	SUCCESS(0,"抢购成功"),
	/**
	 * ERROR
	 */
    ERROR(-1,"系统异常"),
    /**
	 * NO_TIME
	 */
    NO_TIME(-2,"不在抢购时间"),
    /**
	 * HAVING
	 */
    HAVING(-3,"已拥有该英雄"),
    /**
	 * NO_MONEY
	 */
    NO_MONEY(-4,"余额不足"),
    /**
	 * NO_GOODS
	 */
	NO_GOODS(-5,"已售完");
	private int state;
    private String stateInfo;
    RushStatEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public static RushStatEnum getRushEnum(int state){
		for(RushStatEnum rushEnum : values()){
            if(rushEnum.getState() == state){
                return rushEnum;
            }
        }
        return null;
	}
	public static void main(String[] args) {
		System.out.println(RushStatEnum.SUCCESS);
	}
}
