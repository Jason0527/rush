package com.jason.boot.specific.rush.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jason.boot.common.utils.IdGen;
import com.jason.boot.specific.rush.dao.LolUserMapper;
import com.jason.boot.specific.rush.dao.RushHeroMapper;
import com.jason.boot.specific.rush.dao.RushRecordMapper;
import com.jason.boot.specific.rush.dao.UserAssetMapper;
import com.jason.boot.specific.rush.entity.RushRecord;
import com.jason.boot.specific.rush.entity.RushStatEnum;
/**
 * 关键的业务核心
 * @author jason
 *
 */
@Service
public class RushService {
	@Autowired
	RushHeroMapper heroDao;
	@Autowired
	UserAssetMapper assetDao;
	@Autowired
	LolUserMapper userDao;
	@Autowired
	RushRecordMapper recordDao;

	@Transactional
	public RushStatEnum rush(String loginNo, String heroName) {
		try {
			Date now = new Date();
			try {
				// 先将该英雄的剩余份数-1
				int heroDaoCount = heroDao.reduceNum(heroName, now);
				// 如果未更新成功能且没报异常，则证明未在活动时间
				if (heroDaoCount == 0) {
					return RushStatEnum.NO_TIME;
				}
				// 如果报检查异常，则证明该英雄份数=0，已经售完
			} catch (DataIntegrityViolationException e) {
				return RushStatEnum.NO_GOODS;
			}
			try {
				// 将该英雄纳入该客户资产
				// 如果报违反唯一性约束，则表明该用户已经拥有该英雄
				assetDao.insertAsset(IdGen.createUUID(), loginNo, heroName);
			} catch (DuplicateKeyException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return RushStatEnum.HAVING;
			}
			try {
				// 扣除用户余额
				// 如果违反检查约束，则余额不足
				userDao.reduceAccount(loginNo, heroName);
			} catch (DataIntegrityViolationException e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return RushStatEnum.NO_MONEY;
			}
			try {
				// 增加抢购记录
				RushRecord record = new RushRecord();
				record.setId(IdGen.createUUID());
				record.setLoginNo(loginNo);
				record.setHeroName(heroName);
				record.setCreateTime(now);
				recordDao.insert(record);
			} catch (Exception e) {
				e.printStackTrace();
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return RushStatEnum.ERROR;
			}
			return RushStatEnum.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return RushStatEnum.ERROR;
		}
	}

}
