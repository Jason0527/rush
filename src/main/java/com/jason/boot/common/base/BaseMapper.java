package com.jason.boot.common.base;

/**
 * 
 * @author jason
 *	dao 父接口  mybatis-generator自动生成的一些基本方法
 */
public interface BaseMapper {
	/**
	 * 根据主键删除记录
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(String id);
	/**
	 * 插入一条记录（包括空值）
	 * @param record
	 * @return
	 */
	int insert(BaseBean record);
	/**
	 * 插入一条记录（不包括空值）
	 * @param record
	 * @return
	 */
	int insertSelective(BaseBean record);
	/**
	 * 根据主键查询记录
	 * @param id
	 * @return
	 */
	BaseBean selectByPrimaryKey(String id);
	/**
	 * 更新记录（不包括空值）
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(BaseBean record);
	/**
	 * 更新记录（包括空值）
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(BaseBean record);
}
