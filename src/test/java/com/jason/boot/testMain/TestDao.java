package com.jason.boot.testMain;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import com.jason.boot.common.utils.IdGen;
import com.jason.boot.specific.rush.dao.LolUserMapper;
import com.jason.boot.specific.rush.dao.RushHeroMapper;
import com.jason.boot.specific.rush.dao.RushRecordMapper;
import com.jason.boot.specific.rush.dao.UserAssetMapper;
import com.jason.boot.specific.rush.entity.RushHero;
import com.jason.boot.specific.rush.entity.RushStatEnum;
import com.jason.boot.specific.rush.service.RushService;

/**
 * 
 * @author jason
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao {
	@Autowired
	LolUserMapper dao;
	@Autowired
	RushRecordMapper recordDao;
	@Autowired
	RushHeroMapper heroDao;
	@Autowired
	RushService service;
	@Autowired
	UserAssetMapper assetDao;
	@Autowired
	LolUserMapper userDao;
	@Before
	public void before(){
		System.out.println("开始测试TestDao");
	}
	@Test
	public void test1(){
		System.out.println(dao.selectByPrimaryKey("464e4398be2e4240b64267abaec6a02e"));
	}
	@Test
	public void test2(){
		RushHero hero = heroDao.selectByHeroName("riven");
		System.out.println(hero.getHeroName());
	}
	@Test
	public void test3(){
		RushStatEnum state = service.rush("321999836","riven");
		System.out.println(state.getStateInfo());
	}
	@Test
	public void test4(){
		int a=0;
		try{
		a = assetDao.insertAsset(IdGen.createUUID(),"riven","321999836");
		}catch(DuplicateKeyException e){
			System.out.println("已存在该资产");
		}
		System.out.println(a);
	}
	@Test
	public void test5(){
		try{
		userDao.reduceAccount("321999836", "riven");
		}catch(DataIntegrityViolationException e){
			System.out.println("异常");
		}
		}
	@Test
	public void test6(){
		int a = 0;
		try{
		a = heroDao.reduceNum("riven",new Date());
		}catch(DataIntegrityViolationException e){
			System.out.println("异常");
		}
		System.out.println(a);
		}
	@Test
	public void test7(){
		RushStatEnum rushEnum = service.rush("321999836", "vayen");
		System.out.println(rushEnum);
	}
}
