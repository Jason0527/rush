package com.jason.boot.testOthers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jason.boot.common.utils.IdGen;
import com.jason.boot.common.utils.Md5Util;

public class TestOther {
	@Test
	public void test1(){
		for(int i = 0; i<3;i++){
			System.out.println(IdGen.createUUID());
		}
		System.out.println(Md5Util.encode("11111111"));
	}
	@Test
	public void test2(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list);
	}
}
