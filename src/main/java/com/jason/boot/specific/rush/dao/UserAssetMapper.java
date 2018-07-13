package com.jason.boot.specific.rush.dao;

import org.apache.ibatis.annotations.Param;

import com.jason.boot.common.base.BaseMapper;

public interface UserAssetMapper extends BaseMapper {
	public int insertAsset(@Param("id")String id,@Param("loginNo")String loginNo,@Param("heroName")String heroName);
}