package com.jason.boot.common.base;

import java.io.Serializable;
/**
 * 封装返回数据的实体类
 * @author jason
 *
 */
public class ResponseResult implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer state;
	private String msg;
	public ResponseResult(){};
	public ResponseResult(Integer state,String msg){
		this.state=state;
		this.msg=msg;
	}
	public ResponseResult(Integer state,String msg,Object data){
		this.state=state;
		this.msg=msg;
		this.data=data;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	private Object data;
	
	@Override
	public String toString(){
		return "【state="+state+",msg="+msg+"】";
	}
}
