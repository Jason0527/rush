package com.jason.boot.specific.rush.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.jason.boot.common.base.BaseMapper;
import com.jason.boot.specific.rush.entity.RushHero;

public interface RushHeroMapper extends BaseMapper {
	public RushHero selectByHeroName(String heroName);
	public int reduceNum(@Param("heroName")String heroName,@Param("now")Date date);
}