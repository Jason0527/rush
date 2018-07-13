package com.jason.boot.specific.rush.dao;

import org.apache.ibatis.annotations.Param;

import com.jason.boot.common.base.BaseMapper;

public interface LolUserMapper extends BaseMapper{
	public int reduceAccount(@Param("loginNo")String loginNo,@Param("heroName")String heroName);
}